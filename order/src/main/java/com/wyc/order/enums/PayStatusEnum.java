package com.wyc.order.enums;

import lombok.Getter;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Getter
public enum PayStatusEnum {

    WAIT(0,"等待支付"),FINISH(1,"已完成");

    private Integer code;
    private String msg;

    PayStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
