package com.wyc.common.enums;

import lombok.Getter;

/**
 * @author: wyc
 * @date: 2018/11/29
 */
@Getter
public enum ResultEnum {
    PRODUCT_UN_EXIST(0,"产品不存在"),PRODUCT_NOT_ENOUGH_STOCK(1,"库存不足");


    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
