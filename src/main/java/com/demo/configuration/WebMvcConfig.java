package com.demo.configuration;


import com.demo.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

//        registry.addInterceptor(new ApplicationInterceptor())
////                .addPathPatterns("/*");
//        registry.addInterceptor(new DemoInterceptor())
//                .addPathPatterns("/demo");
    }

}
