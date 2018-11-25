package com.wyc.product;

import com.wyc.product.dataobject.ProductCategory;
import com.wyc.product.service.ProductCategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Component
public class ProdcutCategoryServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryService productCategoryService;

    @Test
    public void testFindByCategories(){
        List<ProductCategory> productCategories = productCategoryService.findByProductCategory(Arrays.asList(11,22));
        Assert.assertTrue(productCategories.size() > 0);
    }
}
