package com.jluzh.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yanghongkun
 * @description: 订单头
 * @date: 2020/08/27
 */
@Data
@Entity
public class OrderMaster {
    /**
     * 订单ID
     */
    @Id
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

    /**
     * 订单创建时间，按时间排序
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
