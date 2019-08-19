package com.demo.interceptor;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import com.demo.security.UserDetailsImpl;
import com.demo.security.UserDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CheckCurrentLoggedUserInterceptor implements HandlerInterceptor {

    final UserRepository userRepository;

    @Autowired
    public CheckCurrentLoggedUserInterceptor(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) {
        //System.out.println("ApplicationInterceptor.preHandle");
        try {
            //ModelMap modelMap = modelAndView.getModelMap();
            UserDetailsImpl currentLoggedUser = UserDetailsUtil.getUserDetails();
            if (currentLoggedUser != null) {
                User databaseUser = userRepository.findOneByUsername(currentLoggedUser.getUserName());
                if (databaseUser != null) {
                    if (databaseUser.getActive() == 0) {
                        response.sendRedirect(request.getContextPath() + "/login");
                        return false;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        //System.out.println("ApplicationInterceptor.postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception ex) {
        //System.out.println("ApplicationInterceptor.afterCompletion");
    }
}
