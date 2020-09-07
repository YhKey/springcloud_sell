package com.jluzh.product.dto;

import lombok.Data;

/**
 * @author: yanghongkun
 * @description: 购物车
 * @date: 2020/08/29
 */
@Data
public class CartDTO {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public CartDTO() {
    }
}
