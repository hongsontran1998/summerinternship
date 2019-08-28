package com.demo.service.service.impl;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;
import com.demo.service.CategoryService;
import com.demo.util.OffsetBasedPageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Page<Category> findAllOrFilter(String searchingText, Integer offset, Integer limit, String sortBy, String direction) {
        Pageable pageable = getPageable(offset, limit, sortBy, direction);
        return categoryRepository.findAllOrFilter(searchingText, pageable);
    }

    @Override
    public Page<Category> findAllOrFilterCriteria(String searchingText, Integer offset, Integer limit, String sortBy, String direction) {
        Pageable pageable = getPageable(offset, limit, sortBy, direction);
        return categoryRepository.findAllOrFilterCriteria(searchingText, pageable);
    }

    private Pageable getPageable(Integer offset, Integer limit, String sortBy, String direction) {
        Sort sort = null;
        if (sortBy != null) {
            if ("desc".equalsIgnoreCase(direction) || direction == null) {
                sort = Sort.by(sortBy).descending();
            } else if ("asc".equalsIgnoreCase(direction)) {
                sort = Sort.by(sortBy).ascending();
            }
        } else {
            sort = Sort.by("id").descending();
        }

        if (offset == null) {
            offset = 0;
        }
        if (limit == null) {
            limit = Integer.MAX_VALUE;
        }
        Pageable pageable = new OffsetBasedPageRequest(offset, limit, sort);
        return pageable;
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
