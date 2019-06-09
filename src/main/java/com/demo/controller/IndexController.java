package com.demo.controller;

import com.demo.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("index")
    @ResponseBody
    public int add() {
        return 3 + 4;
    }

    @GetMapping("demo")
    public String demo(ModelMap modelMap) {
        int id = 1;
        String username = "";
        String password = "";
        String fullName = "";
        String email = "";
        String phoneNumber = "";
        String address = "";

        User u = new User(id, username, password, fullName, email, phoneNumber, address);
        System.out.println(u.toString());
        modelMap.addAttribute("name", "tran huu hong son");
        return "index";

    }
    @GetMapping("demo2")
    public ModelAndView demo2() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        modelAndView.addObject("name", "tranhuuhongson");
        return modelAndView;
    }
}
