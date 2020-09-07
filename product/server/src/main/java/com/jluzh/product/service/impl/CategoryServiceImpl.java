package com.jluzh.product.service.impl;

import com.jluzh.product.dataobject.ProductCategory;
import com.jluzh.product.repository.ProductCategoryRepository;
import com.jluzh.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/25
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository productCategoryRepository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeIn(categoryTypeList);
    }
}
