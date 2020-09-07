package com.jluzh.order.controller;

import com.jluzh.product.client.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/28
 */
@RestController
@Slf4j
public class ClientController {

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        //Feign
        String response = productClient.productMsg();
        log.info("【response】={}", response);
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        /*List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("1582421866267265539"));
        log.info("response = {}",productInfoList);*/
        return "ok";
    }

    @GetMapping("/productDecreaseStock")
    public String productDecreaseStock(){
//        productClient.decreaseStock(Arrays.asList(new CartDTO("1582421866267265539",3)));
        return "ok";
    }
}
