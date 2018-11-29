package com.wyc.server.service;


import com.wyc.common.dataopbejct.DecreaseStockInput;
import com.wyc.server.dataobject.ProductInfo;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface ProductInfoService {

    List<ProductInfo> findAll(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);

    void decreaseStock(List<DecreaseStockInput> decreaseStockInputList);
}
