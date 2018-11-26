package com.wyc.order.controller;

import com.wyc.order.converter.OrderForm2OrderDTOConverter;
import com.wyc.order.dto.OrderDTO;
import com.wyc.order.enums.ResultEnum;
import com.wyc.order.form.OrderForm;
import com.wyc.order.service.OrderService;
import com.wyc.order.utils.ResultVoUtil;
import com.wyc.order.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/create")
    public ResultVO create(@Valid OrderForm orderForm, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            ResultVO resultVO = new ResultVO();
            resultVO.setCode(ResultEnum.PARAM_ERROR.getCode());
            resultVO.setMsg(bindingResult.getFieldError().getDefaultMessage());
            return  resultVO;
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        orderDTO = orderService.create(orderDTO);
        return ResultVoUtil.success(orderDTO.getOrderId());
    }

}
