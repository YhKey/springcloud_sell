package com.jluzh.product.common;

import lombok.Data;

/**
 * @author: yanghongkun
 * @description: 减库存入参
 * @date: 2020/08/31
 */
@Data
public class DecreaseStockInput {

    /**
     * 商品ID
     */
    private String productId;

    /**
     * 商品数量
     */
    private Integer productQuantity;

    public DecreaseStockInput(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }

    public DecreaseStockInput() {
    }
}
