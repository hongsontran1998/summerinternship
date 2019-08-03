package com.demo.controller;

import com.demo.email.EmailSendingSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("test")
public class TestSomeUtilClassInSpring {
    @Autowired
    private Environment env;
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    EmailSendingSystem emailSendingSystem;

    @GetMapping("1")
    @ResponseBody
    public String test1() {
        String s = env.getProperty("spring.datasource.username");
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        emailSendingSystem.send();
                        Thread.sleep(100);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        return "OK";
    }

}
