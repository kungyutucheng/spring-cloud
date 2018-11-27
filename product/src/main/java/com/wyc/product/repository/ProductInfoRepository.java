package com.wyc.product.repository;

import com.wyc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findByProductStatus(Integer prductStatus);

    List<ProductInfo> findByProductIdIn(List<String> productIdList);
}
