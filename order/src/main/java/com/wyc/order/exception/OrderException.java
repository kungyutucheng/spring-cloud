package com.wyc.order.exception;

import com.wyc.order.enums.ResultEnum;

/**
 * @author: wyc
 * @date: 2018/11/26
 */
public class OrderException extends RuntimeException{

    private Integer code;
    private String message;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }
}
