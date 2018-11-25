package com.wyc.order.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @PostMapping(value = "/create")
    public void create(){}

}
