package com.wyc.product.service;

import com.wyc.product.dataobject.ProductCategory;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface ProductCategoryService {

    List<ProductCategory> findByProductCategory(List<Integer> categories);
}
