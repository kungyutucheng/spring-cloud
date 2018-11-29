package com.wyc.order.service.impl;

import com.wyc.client.client.ProductClient;
import com.wyc.common.dataopbejct.DecreaseStockInput;
import com.wyc.common.dataopbejct.ProductInfoOutput;
import com.wyc.order.dataobject.OrderDetail;
import com.wyc.order.dataobject.OrderMaster;
import com.wyc.order.dto.OrderDTO;
import com.wyc.order.enums.OrderStatusEnum;
import com.wyc.order.enums.PayStatusEnum;
import com.wyc.order.enums.ResultEnum;
import com.wyc.order.exception.OrderException;
import com.wyc.order.repository.OrderDetailRepository;
import com.wyc.order.repository.OrderMasterRepository;
import com.wyc.order.service.OrderService;
import com.wyc.order.utils.KeyUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        String orderId = KeyUtil.genUniqueKey();

        List<String> productIdList = orderDTO.getOrderDetails().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfoOutput> productInfoOutputs = productClient.getProductList(productIdList);
        BigDecimal orderAmount = BigDecimal.ZERO;
        for (ProductInfoOutput productInfoOutput : productInfoOutputs) {
            for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
                if (StringUtils.equals(orderDetail.getProductId(), productInfoOutput.getProductId())) {
                    int result = orderDetail.getProductQuantity() - productInfoOutput.getProductStock();
                    if (result < 0) {
                        throw new OrderException(ResultEnum.STOCK_UN_ENOUGH);
                    }
                    BeanUtils.copyProperties(productInfoOutput, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    orderDetail.setCreateTime(new Date());
                    orderDetail.setUpdateTime(new Date());
                    orderDetailRepository.save(orderDetail);
                    orderAmount = productInfoOutput.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                }
            }
        }

        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetails().stream().map(item -> new DecreaseStockInput(item.getProductId(), item.getProductQuantity())).collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);


        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;

    }
}
