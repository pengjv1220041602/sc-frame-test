package com.sc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodsController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/goods/{id}")
    public String goodsById (@PathVariable("id") String id) {
        return "this is good " + id + port;
    }

}
