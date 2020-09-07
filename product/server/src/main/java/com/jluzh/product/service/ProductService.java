package com.jluzh.product.service;

import com.jluzh.product.dataobject.ProductInfo;
import com.jluzh.product.dto.CartDTO;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有在架商品
     */
    List<ProductInfo> findUpAllInfo();

    /**
     * 查询商品列表
     * @param productIdList
     * @return
     */
    List<ProductInfo> findList(List<String> productIdList);

    /**
     * 扣库存
     */
    void decreaseStock(List<CartDTO> cartDTOList);
}
