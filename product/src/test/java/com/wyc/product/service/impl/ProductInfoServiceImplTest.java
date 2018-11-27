package com.wyc.product.service.impl;

import com.wyc.product.ProductApplicationTests;
import com.wyc.product.dataobject.ProductInfo;
import com.wyc.product.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: wyc
 * @date: 2018/11/27
 */
@Component
public class ProductInfoServiceImplTest extends ProductApplicationTests{

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findByProductIdIn() throws Exception {

        List<ProductInfo> productInfos = productInfoService.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
        Assert.assertTrue(productInfos.size() > 0);
    }

}