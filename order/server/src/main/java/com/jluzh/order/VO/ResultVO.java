package com.jluzh.order.VO;

import lombok.Data;

/**
 * @author: yanghongkun
 * @description: 返回对象
 * @date: 2020/08/28
 */
@Data
public class ResultVO<T> {

    /**
     * 错误码
     */
    private Integer code;

    /**
     * 提示信息
     */
    private String message;

    /**
     * 具体内容
     */
    private T data;

}

