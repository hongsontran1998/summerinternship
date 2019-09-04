package com.demo.controller.web;

import com.demo.entity.Article;
import com.demo.entity.Category;
import com.demo.repository.ArticleRepository;
import com.demo.repository.CategoryRepository;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("test")
public class TestController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ArticleRepository articleRepository;


    @Autowired
    Environment env;


    @GetMapping("test1")
    @ResponseBody
    public String test1() {
        //Category category = categoryRepository.findById(1).get();
        Category c = categoryRepository.findById(1).get();
        return "";
    }
}
