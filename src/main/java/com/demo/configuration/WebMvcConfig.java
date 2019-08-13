package com.demo.configuration;


import com.demo.interceptor.ApplicationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@EnableWebMvc
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

//    @Bean
//    public ApplicationInterceptor applicationInterceptor() {
//        return new ApplicationInterceptor();
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new ApplicationInterceptor())
                .addPathPatterns("/*");

//        registry.addInterceptor(new DemoInterceptor())
//                .addPathPatterns("/demo");
    }

}
