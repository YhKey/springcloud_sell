package com.jluzh.order.form;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author: yanghongkun
 * @description: 订单创建参数
 * @date: 2020/08/28
 */
@Data
public class OrderForm {

    /**
     * 买家姓名
     */
    @NotEmpty(message = "姓名必填")
    private String name;

    /**
     * 买家手机号
     */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /**
     * 买家地址
     */
    @NotEmpty(message = "地址必填")
    private String address;

    /**
     * 买家openId
     */
    @NotEmpty(message = "openid必填")
    private String openid;

    /**
     * 购物车信息
     */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
