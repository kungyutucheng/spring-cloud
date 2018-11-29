package com.wyc.server.service;


import com.wyc.server.dataobject.ProductCategory;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface ProductCategoryService {

    List<ProductCategory> findByProductCategory(List<Integer> categories);
}
