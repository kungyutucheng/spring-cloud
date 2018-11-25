package com.wyc.product;

import com.wyc.product.dataobject.ProductInfo;
import com.wyc.product.service.ProductInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Component
public class ProductInfoServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductInfoService productInfoService;


    @Test
    public void testFindAll(){
        List<ProductInfo> productInfos = productInfoService.findAll(0);
        Assert.assertTrue(productInfos.size() > 0);
    }

}
