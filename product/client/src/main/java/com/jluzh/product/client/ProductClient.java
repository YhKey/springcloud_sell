package com.jluzh.product.client;

import com.jluzh.product.common.DecreaseStockInput;
import com.jluzh.product.common.ProductInfoOutput;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author: yanghongkun
 * @description: 定义Feign需要调用接口（作为客户端）
 * @date: 2020/08/28
 */
//表示要访问哪个应用
@FeignClient(name = "product")
public interface ProductClient {
    //该应用下的接口
    @GetMapping("/msg")
    String productMsg();

    @PostMapping("/product/listForOrder")
    List<ProductInfoOutput> listForOrder(List<String> productIdList);

    @PostMapping("/product/decreaseStock")
    void decreaseStock(@RequestBody List<DecreaseStockInput> decreaseStockInputList);
}
