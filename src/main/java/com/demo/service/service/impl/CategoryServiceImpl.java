package com.demo.service.service.impl;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;
import com.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return (List<Category>) categoryRepository.findAll();
    }

    @Override
    public Category insertOne(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateOne(Category category) {
        if (findOneById(category.getId()) != null) {
            return categoryRepository.save(category);
        }
        return null;
    }

    @Override
    public Integer deleteOneById(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        if (optional.isPresent()) {
            categoryRepository.deleteById(optional.get().getId());
            return 1;
        }
        return 0;
    }

    @Override
    public Category findOneById(Integer id) {
        Optional<Category> optional = categoryRepository.findById(id);
        return optional.orElse(null);
    }
}
