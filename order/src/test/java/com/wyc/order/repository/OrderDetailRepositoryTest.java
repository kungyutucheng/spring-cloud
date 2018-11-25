package com.wyc.order.repository;

import com.wyc.order.OrderApplicationTests;
import com.wyc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests{
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void save() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCreateTime(new Date());
        orderDetail.setDetailId("fasdsf");
        orderDetail.setOrderId("fadsfs");
        orderDetail.setProductIcon( "http://wwww.baidu.com");
        orderDetail.setProductId("fdasf");
        orderDetail.setProductName("fasf");
        orderDetail.setProductPrice(new BigDecimal(1));
        orderDetail.setProductQuantity(12);
        orderDetail.setUpdateTime(new Date());
        OrderDetail orderDetail1 = orderDetailRepository.save(orderDetail);
        Assert.assertTrue(orderDetail1 != null);
    }

}