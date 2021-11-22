package com.lixiang.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 请求日志打印
 * @author: 张亮
 * @date: 2021/10/24
 **/
@Component
@Slf4j
public class RequesrLogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        log.info("                 请求的路径是:"+request.getRequestURI());
        log.info("                 请求的方法是:"+request.getMethod());
        request.getParameterMap().keySet().forEach(x->{

            log.info("                           请求的参数是:"+x);
            String[] strings = request.getParameterMap().get(x);
            for (int i = 0; i < strings.length; i++) {
                log.info("                           请求的值是:"+x);
            }


        });


        response.setStatus(200);
        return false;
    }
}
