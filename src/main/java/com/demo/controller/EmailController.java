package com.demo.controller;

import com.demo.email.EmailSendingSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("email")
public class EmailController {

    @Autowired
    EmailSendingSystem emailSendingSystem;

    @GetMapping("send")
    @ResponseBody
    public String test1() {
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    emailSendingSystem.send();
                    Thread.sleep(100);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        return "OK";
    }

}
