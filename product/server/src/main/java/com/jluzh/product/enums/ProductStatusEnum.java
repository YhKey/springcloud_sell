package com.jluzh.product.enums;

import lombok.Getter;

/**
* @author: yanghongkun
* @description: 商品上下架状态
* @date: 2020/8/25
*/
@Getter
public enum ProductStatusEnum {

    UP(0,"在架"),
    DOWN(1,"下架"),
    ;

    private Integer code;

    private String message;

    ProductStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
