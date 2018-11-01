package com.sc.controller;

import org.springframework.stereotype.Component;

@Component
public class ErrorOrder implements OrderInterface {
    @Override
    public String goodsById(String id) {
        return "error";
    }
}
