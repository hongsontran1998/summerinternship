package com.demo.database.seed;

import com.demo.database.factory.JsonFactory;
import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
public class CategoriesTableSeeder implements Seeder {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public void run() {
        List<Category> categories = new ArrayList<>();
        JsonNode nodeCategories = JsonFactory.getJsonNode("categories");
        nodeCategories.forEach(item ->
                categories.add(new Category(null, item.asText()))
        );
//        Faker faker = new Faker(new Locale("vi"));
//        for (int i = 0; i < 10; i++) {
//            categories.add(new Category(null, faker.animal().name()));
//        }
        categoryRepository.saveAll(categories);
    }
}
