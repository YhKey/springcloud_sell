package com.jluzh.order.dto;

import com.jluzh.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author: yanghongkun
 * @description: 订单传输对象
 * @date: 2020/08/27
 */
@Data
public class OrderDTO {
    /**
     * 订单ID
     */
    private String orderId;

    /**
     * 买家名字
     */
    private String buyerName;

    /**
     * 买家手机
     */
    private String buyerPhone;

    /**
     * 买家地址
     */
    private String buyerAddress;

    /**
     * 买家微信OpenID
     */
    private String buyerOpenid;

    /**
     * 订单总金额
     */
    private BigDecimal orderAmount;

    /**
     * 订单状态,默认为新下单0，
     */
    private Integer orderStatus;

    /**
     * 支付状态，默认未支付0，
     */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
