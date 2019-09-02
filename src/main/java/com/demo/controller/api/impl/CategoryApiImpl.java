package com.demo.controller.api.impl;

import com.demo.controller.api.CategoryApi;
import com.demo.entity.Category;
import com.demo.service.CategoryService;
import com.demo.service.Result;
import com.demo.util.ValidationUtil;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import javax.validation.Valid;
import java.util.Map;

@Component
public class CategoryApiImpl implements CategoryApi {

    private final CategoryService categoryService;

    public CategoryApiImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public ResponseEntity<Result> findAllOrFilter(
            String searchingText,
            Integer offset,
            Integer limit,
            String sortBy,
            String direction) {
        Result result = new Result();
        //Page<Category> categories = categoryService.findAllOrFilter(searchingText, offset, limit, sortBy, direction);
        Page<Category> categories =
                categoryService.findAllOrFilterCriteria(searchingText, offset, limit, sortBy, direction);
        result.setData(categories);
        result.setStatus(Result.Status.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Result> findOneById(Integer id) {
        Category category = categoryService.findOneById(id);
        Result result = new Result();
        if (category == null) {
            result.setMessage("Category is not found");
            result.setStatus(Result.Status.FAILED);
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.setStatus(Result.Status.SUCCESS);
            result.setData(category);
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<Result> insertOne(@Valid Category category, BindingResult br) {
        Result result = new Result();
        Map<String, Object> message = ValidationUtil.getMessageModelFromBindingResult(br);
        if (message != null) { //HAS ERRORS 400 BAD REQUEST
            result.setStatus(Result.Status.FAILED);
            result.setMessage(message);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            Category newCategory = categoryService.insertOne(category);
            result.setStatus(Result.Status.SUCCESS);
            result.setData(newCategory);

            return new ResponseEntity<>(result, HttpStatus.CREATED);
        }
    }

    @Override
    public ResponseEntity<Result> updateOne(@Valid Category category, BindingResult br) {
        Result result = new Result();
        Map<String, Object> message = ValidationUtil.getMessageModelFromBindingResult(br);
        if (message != null) {
            result.setMessage(message);
            result.setStatus(Result.Status.FAILED);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            Category newCategory = categoryService.updateOne(category);
            if (newCategory != null) {
                result.setStatus(Result.Status.SUCCESS);
                result.setData(newCategory);
                return new ResponseEntity<>(result, HttpStatus.OK);
            } else {
                result.setStatus(Result.Status.FAILED);
                result.setMessage("Category is not found");
                return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
            }
        }
    }

    @Override
    public ResponseEntity<Result> deleteOneById(Integer id) {
        Result result = new Result();
        if (categoryService.deleteOneById(id) > 0) {
            result.setStatus(Result.Status.SUCCESS);
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            result.setStatus(Result.Status.FAILED);
            result.setMessage("Category is not found");
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<Result> findOneBySlug(String slug) {
        Category category = categoryService.findBySlug(slug);
        Result result = new Result();
        result.setData(category);
        result.setStatus(Result.Status.SUCCESS);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

}
