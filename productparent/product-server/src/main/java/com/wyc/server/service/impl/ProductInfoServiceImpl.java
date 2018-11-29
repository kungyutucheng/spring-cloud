package com.wyc.server.service.impl;

import com.wyc.common.dataopbejct.DecreaseStockInput;
import com.wyc.common.enums.ResultEnum;
import com.wyc.common.exception.ProductException;
import com.wyc.server.dataobject.ProductInfo;
import com.wyc.server.repository.ProductInfoRepository;
import com.wyc.server.service.ProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findByProductIdIn(List<String> productIdList) {
        return productInfoRepository.findByProductIdIn(productIdList);
    }

    @Override
    public void decreaseStock(List<DecreaseStockInput> decreaseStockInputList) {
        for(DecreaseStockInput decreaseStockInput : decreaseStockInputList){
            Optional<ProductInfo> productInfoOptional = productInfoRepository.findById(decreaseStockInput.getProductId());
            if(!productInfoOptional.isPresent()){
                throw new ProductException(ResultEnum.PRODUCT_UN_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            int result = productInfo.getProductStock() - decreaseStockInput.getProductQuantity();
            if(result < 0){
                throw new ProductException(ResultEnum.PRODUCT_NOT_ENOUGH_STOCK);
            }
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }
}
