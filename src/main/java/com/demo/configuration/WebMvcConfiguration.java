package com.demo.configuration;


import com.demo.interceptor.ApplicationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*// LogInterceptor áp dụng cho mọi URL.
        registry.addInterceptor(new LogInterceptor());

        // Đường dẫn login cũ, không còn sử dụng nữa.
        // Sử dụng OldURLInterceptor để điều hướng tới một URL mới.
        registry.addInterceptor(new OldLoginInterceptor())//
                .addPathPatterns("/admin/oldLogin");

        // Interceptor này áp dụng cho các URL có dạng /admin/*
        // Loại đi trường hợp /admin/oldLogin
        registry.addInterceptor(new AdminInterceptor())//
                .addPathPatterns("/admin/*")//
                .excludePathPatterns("/admin/oldLogin");*/
        registry.addInterceptor(new ApplicationInterceptor())
                .addPathPatterns("/*");
    }

}
