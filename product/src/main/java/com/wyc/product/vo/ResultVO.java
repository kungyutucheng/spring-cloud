package com.wyc.product.vo;

import lombok.Data;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Data
public class ResultVO<T> {

    private Integer code;

    private String msg;

    private T data;
}
