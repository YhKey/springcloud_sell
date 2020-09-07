package com.jluzh.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: yanghongkun
 * @description: 商品信息
 * @date: 2020/08/23
 */
//@Table(name = "T_product_info") 表名不一致的情况下
@Data
@Entity
public class ProductInfo {
    @Id
    private String productId;

    /**
     * 名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal productPrice;

    /**
     *  库存
     */
    private Integer productStock;

    /**
     * 描述
     */
    private String productDescription;

    /**
     * 小图连接,使用链接，支持分布式
     * （如果使用传统的图片上传方式，传到某台服务器的路径下，达不到分布式的目的）
     * 解决：使用第三方CDN存储，或者专门搭一台文件服务器
     */
    private  String productIcon;

    /**
     *  状态：0正常1下架
     */
    private Integer productStatus;

    /**
     * 类目编号
     */
    private Integer categoryType;


    private Date createTime;

    private Date updateTime;
}
