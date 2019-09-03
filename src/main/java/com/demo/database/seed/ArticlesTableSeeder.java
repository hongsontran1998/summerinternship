package com.demo.database.seed;

import com.demo.database.factory.JsonFactory;
import com.demo.entity.Article;
import com.demo.entity.Category;
import com.demo.repository.ArticleRepository;
import com.demo.repository.CategoryRepository;
import com.demo.util.SlugUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class ArticlesTableSeeder implements Seeder {

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run() {
        JsonNode nodeCategories = JsonFactory.getJsonNode("articles");
        List<Article> articles = new ArrayList<>();
        nodeCategories.forEach(jsonNode -> {
            String name = jsonNode.get("name").asText();
            String description = jsonNode.get("description").asText();
            String detail = jsonNode.get("detail").asText();
            String slug = SlugUtil.makeSlug(name);
            Category category = categoryRepository.findById(jsonNode.get("category_id").asInt()).get();
            //Category category = new Category(jsonNode.get("category_id").asInt(), null, null, null);
            articles.add(new Article(null, category, name, description, detail, slug));
        });
        articleRepository.saveAll(articles);
    }
}
