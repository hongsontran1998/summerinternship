package com.demo.controller;

import com.demo.entity.User;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("login")
    public String login() {
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
        User u = userRepository.findById(1).get();
//        List<User> users = (List<User>) userRepository.findAll();
        return "auth/login";
    }
}
