package com.jluzh.order.repository;

import com.jluzh.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: yanghongkun
 * @description: 订单头DAO
 * @date: 2020/08/27
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
