package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author ZhPJ
 * @Date 2018/11/6 000610:24
 * @Version 1.0
 * @Description:
 */
@Controller
public class SecurityController {
    @RequestMapping(path = "/security", method = RequestMethod.GET)
    public String security() {
        return "login";
    }
}
