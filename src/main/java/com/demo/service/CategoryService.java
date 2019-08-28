package com.demo.service;

import com.demo.entity.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    //findAllOrFilter
    Page<Category> findAllOrFilter(String searchingText, Integer offset, Integer limit, String sortBy, String direction);
    Page<Category> findAllOrFilterCriteria(String searchingText, Integer offset, Integer limit, String sortBy, String direction);
    Category findOneById(Integer id);
    Category insertOne(Category category);
    Category updateOne(Category category);
    Integer deleteOneById(Integer id);
}
