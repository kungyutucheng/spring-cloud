package com.wyc.server.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Data
public class ProductInfoVO {

    @JsonProperty(value = "name")
    private String productName;

    @JsonProperty(value = "id")
    private String productId;

    @JsonProperty(value = "price")
    private BigDecimal productPrice;

    @JsonProperty(value = "description")
    private String productDescription;

    @JsonProperty(value = "icon")
    private String productIcon;
}
