package com.wyc.client.client;

import com.wyc.common.dataopbejct.DecreaseStockInput;
import com.wyc.common.dataopbejct.ProductInfoOutput;
import com.wyc.common.vo.ResultVO;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/27
 */
@FeignClient(name = "product-server")
public interface ProductClient {

    @PostMapping(value = "/product/orderProductMsg")
    ResultVO<List<ProductInfoOutput>> getProductList(List<String> productIdList);

    @PostMapping(value = "/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
