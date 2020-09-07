package com.jluzh.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: yanghongkun
 * @description:
 * @date: 2020/08/28
 */
@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String msg(){
        return  "this is product msg 1";
    }
}
