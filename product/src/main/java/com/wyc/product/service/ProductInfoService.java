package com.wyc.product.service;

import com.wyc.product.dataobject.ProductInfo;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface ProductInfoService {

    List<ProductInfo> findAll(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
