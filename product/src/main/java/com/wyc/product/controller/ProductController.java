package com.wyc.product.controller;

import com.wyc.product.ResultVoUtil;
import com.wyc.product.dataobject.ProductCategory;
import com.wyc.product.dataobject.ProductInfo;
import com.wyc.product.enums.ProductStatusEnum;
import com.wyc.product.service.ProductCategoryService;
import com.wyc.product.service.ProductInfoService;
import com.wyc.product.vo.ProductInfoVO;
import com.wyc.product.vo.ProductVO;
import com.wyc.product.vo.ResultVO;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductInfoService productInfoService;

    @Autowired
    private ProductCategoryService productCategoryService;

    @GetMapping(value = "/list")
    public ResultVO<ProductVO> list(){
        List<ProductInfo> productInfos = productInfoService.findAll(ProductStatusEnum.UP.getCode());

        List<Integer> categoryTypes = productInfos.stream().map(ProductInfo::getCategoryType).collect(Collectors.toList());

        List<ProductCategory> categories = productCategoryService.findByProductCategory(categoryTypes);


        List<ProductVO> productVOS = new ArrayList<>();
        for(ProductCategory category : categories){

            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(category.getCategoryName());
            productVO.setCategoryType(category.getCategoryType());
            List<ProductInfoVO> productInfoVOS = new ArrayList<>();
            for(ProductInfo productInfo : productInfos){
                if(productInfo.getCategoryType().equals(category.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOS.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOS(productInfoVOS);
            productVOS.add(productVO);
        }

        return ResultVoUtil.success(productVOS);
    }

    @PostMapping(value = "/orderProductMsg")
    public ResultVO<List<ProductInfo>> orderProductMsg(@RequestBody List<String> productIdList){
        List<ProductInfo> productInfos = productInfoService.findByProductIdIn(productIdList);
        return ResultVoUtil.success(productInfos);
    }
}
