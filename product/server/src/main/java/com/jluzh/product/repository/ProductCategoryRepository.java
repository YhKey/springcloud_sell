package com.jluzh.product.repository;

import com.jluzh.product.dataobject.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Integer> {
    //获取类目type列表
    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);
}
