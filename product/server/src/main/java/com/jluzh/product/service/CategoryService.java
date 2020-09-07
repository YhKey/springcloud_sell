package com.jluzh.product.service;

import com.jluzh.product.dataobject.ProductCategory;

import java.util.List;

public interface CategoryService {
    //获取类目type列表
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
