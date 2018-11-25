package com.wyc.order.enums;

import lombok.Getter;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Getter
public enum  OrderStatusEnum {

    NEW(0,"新订单"),FINISH(1,"已完成"),CANCLE(2,"已取消");

    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
