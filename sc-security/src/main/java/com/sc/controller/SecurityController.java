package com.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author ZhPJ
 * @Date 2018/11/6 000610:24
 * @Version 1.0
 * @Description:
 */
@Controller
public class SecurityController {

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();


    @RequestMapping(path = "/login", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public String security(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String target = savedRequest.getRedirectUrl();
            if (StringUtils.endsWithIgnoreCase(target, ".html")) {
                redirectStrategy.sendRedirect(request, response, "/login");
            }
        }
        return "返回失败需要身份验证";
    }


    @RequestMapping(path = "/error1", method = RequestMethod.GET)
    public String error() {
        return "/error";
    }


    @RequestMapping(path = "/index", method = RequestMethod.POST)
    @ResponseBody
    public String index () {
        return "this is index . html";
    }
}
