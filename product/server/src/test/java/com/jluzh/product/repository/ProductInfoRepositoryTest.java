package com.jluzh.product.repository;

import com.jluzh.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductInfoRepositoryTest {

    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Test
    public void findByProductStatus() {
        List<ProductInfo> productInfoList = productInfoRepository.findByProductStatus(0);
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductIdIn(){
        List<ProductInfo> productInfoList = productInfoRepository.findByProductIdIn(Arrays.asList("1582421866267265538", "1582421866267265539"));
        Assert.assertTrue(productInfoList.size() > 0);
    }
}