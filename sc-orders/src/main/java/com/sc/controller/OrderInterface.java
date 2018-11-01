package com.sc.controller;

import com.sc.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "goodsApplication", configuration = FeignConfig.class, fallback = ErrorOrder.class)
public interface OrderInterface {

    @GetMapping("/goods/{id}")
    String goodsById (@PathVariable("id") String id);

}
