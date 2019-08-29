package com.demo.database.seeds;

import com.demo.database.factories.JsonFactory;
import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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
        categoryRepository.saveAll(categories);
    }
}
