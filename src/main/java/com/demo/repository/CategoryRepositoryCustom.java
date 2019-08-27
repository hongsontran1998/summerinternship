package com.demo.repository;

import com.demo.entity.Category;

import java.util.List;

public interface CategoryRepositoryCustom {
    List<Category> findByHibernate();
    List<Category> findByCriteriaBuilder();
    List<Category> findByJdbcTemplate();
}
