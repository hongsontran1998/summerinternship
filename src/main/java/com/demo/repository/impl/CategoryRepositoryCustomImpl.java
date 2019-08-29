package com.demo.repository.impl;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
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
    public Page<Category> findAllOrFilterCriteria(String searchingText, Pageable pageable) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        //Select paginated list
        CriteriaQuery<Category> selectQuery = builder.createQuery(Category.class);
        Root<Category> categoryRoot = selectQuery.from(Category.class);

        Predicate categoryNamePredicate = builder.like(categoryRoot.get("name"), "%" + searchingText + "%");
        if (searchingText != null)
            selectQuery.where(categoryNamePredicate);

        if (pageable != null) {
            List<Order> orders = new ArrayList<>();
            if (pageable != null && pageable.getSort() != null) {
                pageable.getSort().forEach(order -> {
                    if (order.getDirection().toString().equalsIgnoreCase("DESC")) {
                        orders.add(builder.desc(categoryRoot.get(order.getProperty())));
                    } else if (order.getDirection().toString().equalsIgnoreCase("ASC")) {
                        orders.add(builder.asc(categoryRoot.get(order.getProperty())));
                    }
                });
            }
            if (orders.size() > 0)
                selectQuery.orderBy(orders);
        }

        TypedQuery<Category> q = entityManager.createQuery(selectQuery);
        List<Category> content = q
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize())
                .getResultList();

        //Get total of result
        CriteriaQuery<Long> countQuery = builder.createQuery(Long.class);
        Root<Category> categoriesRootCount = countQuery.from(Category.class);
        countQuery.select(builder.count(categoriesRootCount));
        if (searchingText != null)
            countQuery.where(categoryNamePredicate);
        // Fetches the count of all Books as per given criteria
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        //return pageable: Page<Category>
        return new PageImpl<>(content, pageable, count);
    }

    @Override
    public List<Category> findByJdbcTemplate() {
        String sql = "select * from categories where id > ?";
        return jdbcTemplate.query(sql, new Object[]{10}, new BeanPropertyRowMapper<>(Category.class));
    }
}
