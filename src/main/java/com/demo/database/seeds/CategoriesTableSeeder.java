package com.demo.database.seeds;

import com.demo.entity.Category;
import com.demo.repository.CategoryRepository;
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
        for (int i = 0; i < 2; i++) {
            categories.add(new Category(null, "category " + i));
        }
        categoryRepository.saveAll(categories);
    }
}
