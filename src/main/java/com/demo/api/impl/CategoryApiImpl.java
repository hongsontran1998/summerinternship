package com.demo.api.impl;

import com.demo.api.CategoryApi;
import com.demo.entity.Category;
import com.demo.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CategoryApiImpl implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryApiImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Object> findAll() {
        Map<String, Object> model = new HashMap<>();
        model.put("message", "Found");
        model.put("data", categoryService.findAll());
        return new ResponseEntity<>(model, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> findOneById(Integer id) {
        Category category = categoryService.findOneById(id);
        if (category == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } else {
            Map<String, Object> model = new HashMap<>();
            model.put("message", "Found");
            model.put("data", category);
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
    }

    @Override
    public ResponseEntity<Object> insertOne(Category category) {
        Category newCategory = categoryService.insertOne(category);
        Map<String, Object> model = new HashMap<>();
        model.put("message", "Created");
        model.put("data", newCategory);
        return new ResponseEntity<>(model, HttpStatus.CREATED);
    }

}
