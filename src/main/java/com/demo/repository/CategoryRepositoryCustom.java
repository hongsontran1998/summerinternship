package com.demo.repository;

import com.demo.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<Category> findByHibernate();
    Page<Category> findAllOrFilterCriteria(String searchingText, Pageable pageable);
    List<Category> findByJdbcTemplate();
}
