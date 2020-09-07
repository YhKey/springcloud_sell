package com.jluzh.product.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/**
 * @author: yanghongkun
 * @description: 类目
 * @date: 2020/08/23
 */
@Data
@Entity
public class ProductCategory {
    /**
     * 类目ID
     */
    @Id
    //自增
    @GeneratedValue
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /**
     * 类目名称
     */
    private String categoryName;

    /**
     * 类目编号
     */
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;
}
