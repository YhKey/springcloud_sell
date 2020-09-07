package com.jluzh.order.repository;

import com.jluzh.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
* @author: yanghongkun
* @description:
* @date: 2020/8/27
*/
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String> {

}
