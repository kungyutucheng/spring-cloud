package com.wyc.order.enums;

import lombok.Getter;

/**
 * @author: wyc
 * @date: 2018/11/26
 */
@Getter
public enum ResultEnum {

    PARAM_ERROR(1,"参数错误"),CART_EMPTY(2,"购物车为空"),STOCK_UN_ENOUGH(3,"库存不足");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
