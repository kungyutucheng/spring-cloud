package com.wyc.common.dataopbejct;

import lombok.Data;

/**
 * @author: wyc
 * @date: 2018/11/29
 */
@Data
public class DecreaseStockInput {

    private String productId;

    private Integer productQuantity;

    public DecreaseStockInput() {
    }

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
