package com.wyc.common.exception;

import com.wyc.common.enums.ResultEnum;

/**
 * @author: wyc
 * @date: 2018/11/29
 */
public class ProductException extends RuntimeException {

    private Integer code;

    private String message;

    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        this.code = resultEnum.getCode();
        this.message = resultEnum.getMessage();
    }


}
