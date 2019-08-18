package com.demo.configuration;


import com.demo.interceptor.CheckCurrentLoggedUserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    private CheckCurrentLoggedUserInterceptor checkCurrentLoggedUserInterceptor;

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
