package com.wyc.product.service.impl;

import com.wyc.product.dataobject.ProductCategory;
import com.wyc.product.repository.ProductCategoryRepository;
import com.wyc.product.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByProductCategory(List<Integer> categories) {
        return productCategoryRepository.findByCategoryTypeIn(categories);
    }
}
