package com.wyc.order.controller;

import com.wyc.order.client.ProductClient;
import com.wyc.order.dataobject.ProductInfo;
import com.wyc.order.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author: wyc
 * @date: 2018/11/27
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping(value = "getProductMsg")
    public void getProductMsg(){
        ResultVO<List<ProductInfo>> productInfos = productClient.getProductList(Arrays.asList("157875196366160022","157875227953464068"));
        log.info("response = {}",productInfos);
    }

}
