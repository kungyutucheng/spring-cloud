package com.wyc.server.service;

import com.wyc.server.ProductServerApplicationTests;
import com.wyc.server.dataobject.ProductInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/29
 */
@Component
public class ProductInfoServiceTest extends ProductServerApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;

    @Test
    public void findAll() throws Exception {
    }

    @Test
    public void findByProductIdIn() throws Exception {
        List<ProductInfo> productInfos = productInfoService.findByProductIdIn(Arrays.asList("157875196366160022","157875227953464068"));
    }
}
