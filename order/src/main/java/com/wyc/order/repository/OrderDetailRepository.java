package com.wyc.order.repository;

import com.wyc.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: wyc
 * @date: 2018/11/25
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String>{

    OrderDetail save(OrderDetail orderDetail);

}
