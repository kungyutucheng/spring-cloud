package com.wyc.order.exception;

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
}
