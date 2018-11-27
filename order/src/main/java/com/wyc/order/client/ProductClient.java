package com.wyc.order.client;

import com.wyc.order.dataobject.ProductInfo;
import com.wyc.order.vo.ResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/27
 */
@FeignClient(name = "product")
public interface ProductClient {

    @PostMapping(value = "/product/orderProductMsg")
    ResultVO<List<ProductInfo>> getProductList(List<String> productIdList);
}
