package com.demo.service;

import com.demo.entity.Category;

import java.util.List;

public interface CategoryService {
    List<Category> findAll();
    Category findOneById(Integer id);
    Category insertOne(Category category);
    Category updateOne(Category category);
    Integer deleteOneById(Integer id);
}
