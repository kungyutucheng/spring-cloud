package com.wyc.server.service.impl;

import com.wyc.server.dataobject.ProductCategory;
import com.wyc.server.repository.ProductCategoryRepository;
import com.wyc.server.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
