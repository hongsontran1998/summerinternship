package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ErrorController {

    @GetMapping("/403")
    @ResponseBody
    public String error403() {
        return "<h1>error 403</h1>";
    }

    @GetMapping("/404")
    @ResponseBody
    public String error404() {
        return "<h1>error 404</h1>";
    }
}
