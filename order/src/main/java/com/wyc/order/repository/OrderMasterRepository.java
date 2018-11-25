package com.wyc.order.repository;

import com.wyc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {

    OrderMaster save(OrderMaster orderMaster);
}
