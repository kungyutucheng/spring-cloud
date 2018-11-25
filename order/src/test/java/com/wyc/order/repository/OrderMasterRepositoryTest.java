package com.wyc.order.repository;

import com.wyc.order.OrderApplicationTests;
import com.wyc.order.dataobject.OrderDetail;
import com.wyc.order.dataobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Test
    public void save() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("fsadsf");
        orderMaster.setBuyerName("fadsf");
        orderMaster.setBuyerOpenid("fdasf");
        orderMaster.setCreateTime(new Date());
        orderMaster.setBuyerPhone("15624339283");
        orderMaster.setOrderAmount(new BigDecimal(12));
        orderMaster.setOrderId("fadsfa");
        orderMaster.setOrderStatus(1);
        orderMaster.setPayStatus(0);
        orderMaster.setUpdateTime(new Date());
        OrderMaster orderMaster1 = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(orderMaster1 != null);
    }
}