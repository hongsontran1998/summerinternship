package com.demo.controller;

import com.demo.repository.SpringBootHibernateDAO;
import com.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SpringBootHibernateDAO testDAO;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    Environment env;

    @Value("${app.url}")
    private String appUrl;

    //private final String APP_URL = null;

    public AuthController(@Value("${app.url}") final String url) {
//        System.out.println("AuthController.AuthController");
//        System.out.println(url);
//        System.out.println(appUrl);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("login")
    public String login(@Value("${app.url}") String testUrl) {
        //3 way to get application.properties value
//        System.out.println(env.getProperty("app.url"));
//        System.out.println(appUrl);
//        System.out.println(testUrl);
//        System.out.println("========================");

//        System.out.println(new BCryptPasswordEncoder().encode("123"));
//        User u = userRepository.findById(1).get();
//        List<User> users = (List<User>) userRepository.findAll();
//        List<Category> list = testDAO.test();
//        LOGGER.trace("This is TRACE");
//        LOGGER.debug("This is DEBUG");
//        LOGGER.info("Login infomation: ");
//        LOGGER.info("getRemoteAddr: " + request.getRemoteAddr());
//        LOGGER.info("getLocalAddr: " + request.getLocalAddr());
//        LOGGER.info("getLocalPort: " + request.getLocalPort());
//        LOGGER.info("getLocalName: " + request.getLocalName());
//        LOGGER.info("getRemoteUser: " + request.getRemoteUser());
//        LOGGER.info("getRemotePort: " + request.getRemotePort());
//        LOGGER.warn("This is WARN");
//        LOGGER.error("This is ERROR");

        return "auth/login";
    }
}
