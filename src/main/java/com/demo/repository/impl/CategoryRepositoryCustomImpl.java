package com.demo.repository.impl;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Category> findByHibernate() {
        return entityManager.createQuery("select c from Category c", Category.class).getResultList();
    }

    @Override
    public List<Category> findByCriteriaBuilder() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = builder.createQuery(Category.class);

        Root<Category> category = query.from(Category.class);
        Predicate categoryIdPredicate = builder.greaterThan(category.get("id"), 2);
        Predicate categoryNamePredicate = builder.like(category.get("name"), "%java%");
        query.where(categoryIdPredicate, categoryNamePredicate);

        TypedQuery<Category> q = entityManager.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Category> findByJdbcTemplate() {
        String sql = "select * from categories where id > ?";
        return jdbcTemplate.query(sql, new Object[]{10}, new BeanPropertyRowMapper<>(Category.class));
    }
}
