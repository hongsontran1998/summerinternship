package com.demo.api.impl;

import com.demo.api.CategoryApi;
import com.demo.entity.Category;
import com.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CategoryApiImpl implements CategoryApi {

    private final CategoryService categoryService;

    //constructor injection
    public CategoryApiImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    //post this question on spring framework fb group

    @Override
    public ResponseEntity<List<Category>> findAll() {
        return new ResponseEntity<>(categoryService.findAll(), HttpStatus.OK);
    }
}
