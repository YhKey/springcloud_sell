package com.jluzh.order.exception;

import com.jluzh.order.enums.ResultEnum;
import org.bouncycastle.cert.ocsp.Req;

/**
 * @author: yanghongkun
 * @description: 订单异常
 * @date: 2020/08/28
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
