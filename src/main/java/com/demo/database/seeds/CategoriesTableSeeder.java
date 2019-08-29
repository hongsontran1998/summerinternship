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
        System.out.println("CategoriesTableSeeder.run");
        List<Category> categories = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            categories.add(new Category(null, "category " + i));
        }
        categoryRepository.saveAll(categories);
        System.out.println("==========================");
    }
}
