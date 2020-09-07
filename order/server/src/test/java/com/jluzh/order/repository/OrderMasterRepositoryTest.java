package com.jluzh.order.repository;

import com.jluzh.OrderApplicationTests;
import com.jluzh.order.dataobject.OrderMaster;
import com.jluzh.order.enums.OrderStatusEnum;
import com.jluzh.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMasterRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderMasterRepository orderMasterRepository;
    private final String OPENID="971008";

    @Test
    public void toSave(){
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123456");
        orderMaster.setBuyerName("tushen");
        orderMaster.setBuyerPhone("123321123");
        orderMaster.setBuyerAddress("GF");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(840));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        OrderMaster result = orderMasterRepository.save(orderMaster);
        Assert.assertTrue(result!=null);
    }
}