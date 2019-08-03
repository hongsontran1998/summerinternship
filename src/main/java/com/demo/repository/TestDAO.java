package com.demo.repository;

import com.demo.entity.Category;
import org.hibernate.annotations.Persister;
import org.springframework.data.jpa.convert.QueryByExamplePredicateBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class TestDAO {
    @PersistenceContext
    private EntityManager entityManager;

    public List<Category> test() {
        List<Category> list = entityManager.createQuery("select  c FROM Category c", Category.class)
                .getResultList();
        return list;
    }

    public void testQueryOOP() {
        System.out.println("hahahahah");
    }
}
