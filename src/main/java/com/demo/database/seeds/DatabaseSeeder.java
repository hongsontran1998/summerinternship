package com.demo.database.seeds;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder extends SeedingRunner {

    //@Autowired something

    @EventListener
    public void run(ContextRefreshedEvent event) {
        this.call(new Class[]{
                CategoriesTableSeeder.class,
                RolesTableSeeder.class
        });
    }

}