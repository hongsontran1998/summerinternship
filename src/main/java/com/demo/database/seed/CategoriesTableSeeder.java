package com.demo.database.seed;

import com.demo.database.factory.JsonFactory;
import com.demo.entity.Category;
import com.demo.entity.EntityState;
import com.demo.repository.CategoryRepository;
import com.demo.util.SlugUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriesTableSeeder implements Seeder {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    Faker faker;

    @Override
    public void run() {
        List<Category> categories = new ArrayList<>();
        //get category names from data.json
        JsonNode nodeCategories = JsonFactory.getJsonNode("categories");
        if (nodeCategories != null) {
            nodeCategories.forEach(item ->
                    categories.add(new Category(null,
                            item.asText(),
                            SlugUtil.makeSlug(item.asText()),
                            null,
                            Boolean.TRUE))
            );
        }
        //fake category name by faker
//        for (int i = 0; i < 10; i++) {
//            categories.add(new Category()
//        }
        categoryRepository.saveAll(categories);
    }
}
