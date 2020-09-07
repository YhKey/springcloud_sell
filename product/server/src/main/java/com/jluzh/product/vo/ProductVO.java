package com.jluzh.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author: yanghongkun
 * @description: data vo
 * @date: 2020/08/25
 */
@Data
public class ProductVO {

    /**
     * 为了不影响语义，返回给前端为name
     */
    @JsonProperty("name")
    private String categoryName;

    @JsonProperty("type")
    private Integer categoryType;

    @JsonProperty("foods")
    List<ProductInfoVO> productInfoVOList;
}
