package com.demo.repository;

import com.demo.entity.Article;
import com.demo.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository
        extends CrudRepository<Article, Integer> {

}
