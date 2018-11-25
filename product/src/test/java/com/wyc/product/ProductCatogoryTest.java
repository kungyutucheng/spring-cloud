package com.wyc.product;

import com.wyc.product.dataobject.ProductCategory;
import com.wyc.product.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProductCatogoryTest {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Test
    public void testFindByCategoryType(){
        List<ProductCategory> categories = productCategoryRepository.findByCategoryTypeIn(Arrays.asList(11,22));
        Assert.assertTrue(categories.size() > 0);
    }
}
