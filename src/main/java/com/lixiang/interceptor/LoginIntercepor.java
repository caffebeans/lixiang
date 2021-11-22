package com.lixiang.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/22
 **/
// @Component
@Slf4j
public class LoginIntercepor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

       String user = (String) request.getSession().getAttribute("user");
       System.out.println(user);

        System.out.println(request.getContextPath());

        if (user==null){
            return true;
        }

        return true;
    }
}
