package com.jluzh.product.service;

import com.jluzh.product.ProductApplicationTests;
import com.jluzh.product.dataobject.ProductInfo;
import com.jluzh.product.dto.CartDTO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceTest extends ProductApplicationTests {

    @Autowired
    private ProductService productService;

    @Test
    public void findUpAllInfo() throws Exception{
        List<ProductInfo> list = productService.findUpAllInfo();
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void findList(){
        List<ProductInfo> list = productService.findList(Arrays.asList("1582421866267265538", "1582421866267265539"));
        Assert.assertTrue(list.size()>0);
    }

    @Test
    public void decreaseStock() {
        CartDTO cartDTO = new CartDTO("1582421866267265539",2);
        productService.decreaseStock(Arrays.asList(cartDTO));
    }
}