package com.jluzh.product.exception;

import com.jluzh.product.enums.ResultEnum;

/**
 * @author: yanghongkun
 * @description: 商品异常
 * @date: 2020/08/29
 */
public class ProductException extends RuntimeException{

    private Integer code;

    public ProductException(Integer code,String msg) {
        super(msg);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
