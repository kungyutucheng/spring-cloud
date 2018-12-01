package com.wyc.server.controller;

import com.wyc.common.dataopbejct.DecreaseStockInput;
import com.wyc.common.vo.ResultVO;
import com.wyc.server.ResultVoUtil;
import com.wyc.server.dataobject.ProductCategory;
import com.wyc.server.dataobject.ProductInfo;
import com.wyc.server.enums.ProductStatusEnum;
import com.wyc.server.service.ProductCategoryService;
import com.wyc.server.service.ProductInfoService;
import com.wyc.server.vo.ProductInfoVO;
import com.wyc.server.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
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

    @PostMapping(value = "/decreaseStock")
    public void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList){
        productInfoService.decreaseStock(decreaseStockInputList);
    }
}
