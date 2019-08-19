package com.demo.interceptor;

import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ApplicationInterceptor implements HandlerInterceptor {

    @Autowired
    UserRepository userRepository; //=null

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        //System.out.println("ApplicationInterceptor.preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) {

        System.out.println("ApplicationInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("ApplicationInterceptor.afterCompletion");
    }
}
