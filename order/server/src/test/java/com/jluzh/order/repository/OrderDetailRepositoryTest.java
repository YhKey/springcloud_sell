package com.jluzh.order.repository;

import com.jluzh.OrderApplicationTests;
import com.jluzh.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void saveTest() {
        OrderDetail orderDetail = new OrderDetail(
            "1",
            "2",
            "1582421866267265538",
            "照烧鸡腿饭",
            new BigDecimal(25),
            new Integer(2),
            "http://xxx.com"
        );

        OrderDetail detail = repository.save(orderDetail);
        Assert.assertNotNull(detail);
    }
}