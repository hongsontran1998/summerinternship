package com.demo.configuration;


import com.demo.interceptor.CheckCurrentLoggedUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final CheckCurrentLoggedUserInterceptor checkCurrentLoggedUserInterceptor;

    @Autowired
    public WebMvcConfig(CheckCurrentLoggedUserInterceptor checkCurrentLoggedUserInterceptor) {
        this.checkCurrentLoggedUserInterceptor = checkCurrentLoggedUserInterceptor;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/images/**").addResourceLocations("file:images/");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(checkCurrentLoggedUserInterceptor)
                .excludePathPatterns("/login")
                .addPathPatterns("/admin/**");

//        registry.addInterceptor(new ApplicationInterceptor())
//                .addPathPatterns("/*");

//        registry.addInterceptor(new DemoInterceptor())
//                .addPathPatterns("/demo");
    }

}
