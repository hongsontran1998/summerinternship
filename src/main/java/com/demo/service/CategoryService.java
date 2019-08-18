package com.demo.service;

import com.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category insertOne(Category category);
    Category findOneById(Integer id);
}
