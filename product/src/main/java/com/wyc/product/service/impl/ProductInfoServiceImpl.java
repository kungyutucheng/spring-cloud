package com.wyc.product.service.impl;

import com.wyc.product.dataobject.ProductInfo;
import com.wyc.product.repository.ProductInfoRepository;
import com.wyc.product.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Service
public class ProductInfoServiceImpl implements ProductInfoService {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public List<ProductInfo> findAll(Integer productStatus) {
        return productInfoRepository.findByProductStatus(productStatus);
    }
}
