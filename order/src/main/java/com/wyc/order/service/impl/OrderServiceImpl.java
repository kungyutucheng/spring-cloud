package com.wyc.order.service.impl;

import com.wyc.order.dataobject.OrderMaster;
import com.wyc.order.dto.OrderDTO;
import com.wyc.order.enums.OrderStatusEnum;
import com.wyc.order.enums.PayStatusEnum;
import com.wyc.order.repository.OrderDetailRepository;
import com.wyc.order.repository.OrderMasterRepository;
import com.wyc.order.service.OrderService;
import com.wyc.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO,orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(100));
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMasterRepository.save(orderMaster);
        return orderDTO;

    }
}
