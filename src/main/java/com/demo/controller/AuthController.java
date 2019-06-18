package com.demo.controller;

import com.demo.repository.TestDAO;
import com.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TestDAO testDAO;

    @Autowired
    private HttpServletRequest request;

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("login")
    public String login() {
//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        User u = userRepository.findById(1).get();
//        List<User> users = (List<User>) userRepository.findAll();
//        List<Category> list = testDAO.test();
//        LOGGER.trace("This is TRACE");
//        LOGGER.debug("This is DEBUG");
        LOGGER.info("Login infomation: ");
        LOGGER.info("getRemoteAddr: " + request.getRemoteAddr());
        LOGGER.info("getLocalAddr: " + request.getLocalAddr());
        LOGGER.info("getLocalPort: " + request.getLocalPort());
        LOGGER.info("getLocalName: " + request.getLocalName());
        LOGGER.info("getRemoteUser: " + request.getRemoteUser());
        LOGGER.info("getRemotePort: " + request.getRemotePort());
//        LOGGER.warn("This is WARN");
//        LOGGER.error("This is ERROR");

        return "auth/login";
    }
}
