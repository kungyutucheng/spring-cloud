package com.wyc.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.wyc.order.dataobject.OrderDetail;
import com.wyc.order.dto.OrderDTO;
import com.wyc.order.enums.ResultEnum;
import com.wyc.order.exception.OrderException;
import com.wyc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/26
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm){
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        Gson gson = new Gson();
        List<OrderDetail> orderDetails = new ArrayList<>();
        try{
            orderDetails = gson.fromJson(orderForm.getItems(),new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("转化异常",e);
            throw new OrderException(ResultEnum.CART_EMPTY.getCode(),ResultEnum.CART_EMPTY.getMessage());
        }
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }
}
