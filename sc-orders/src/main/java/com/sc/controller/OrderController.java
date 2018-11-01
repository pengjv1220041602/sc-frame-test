package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    DiscoveryClient discoveryClient;
    @Autowired
    private OrderInterface orderInterface;

    @GetMapping("/order/{id}")
    public String goods (@PathVariable("id") String id) {
        return orderInterface.goodsById(id);
    }

}
