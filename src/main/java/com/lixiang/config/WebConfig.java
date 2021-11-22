package com.lixiang.config;

import com.lixiang.interceptor.LoginIntercepor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description:
 * @author: 张亮
 * @date: 2021/10/22
 **/

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LoginIntercepor()).addPathPatterns("/**").excludePathPatterns("/login");
    }

}
