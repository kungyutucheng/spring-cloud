package com.wyc.product.enums;

import lombok.Getter;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Getter
public enum ProductStatusEnum {
    UP(0,"在架"),DOWN(1,"下架");

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
