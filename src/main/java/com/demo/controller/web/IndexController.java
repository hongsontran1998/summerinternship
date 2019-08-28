package com.demo.controller.web;

import com.demo.security.UserDetailsUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
        System.out.println("IndexController.demo");
        try {
            UserDetailsUtil.getUserDetails();
        } catch (Exception e) {
            e.printStackTrace();
        }

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


    @GetMapping("demo3")
    public String demo3() {
        return "view";
    }

}
