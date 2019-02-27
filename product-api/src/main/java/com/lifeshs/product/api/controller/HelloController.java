package com.lifeshs.product.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试一下
 * Created by dengfeng on 2019/2/27 0027.
 */
@RestController
@RequestMapping(value = "/")
public class HelloController {

    @RequestMapping(value = "/hello")
    String getUserByGet(){
        return "Hello world !";
    }
}
