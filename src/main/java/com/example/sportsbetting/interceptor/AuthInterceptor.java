package com.example.sportsbetting.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object html) throws Exception {
        // WE CHECK BEFORE EVERY REQUEST THAT THE USER IS LOGGED IN OR NOT
        Object USER_ID = request.getSession().getAttribute("USER_ID");
        System.out.println(request.getMethod());
        return true;
    }
}
