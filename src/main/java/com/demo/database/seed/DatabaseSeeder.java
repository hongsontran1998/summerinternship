package com.demo.database.seed;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder extends SeedingCaller {

    //@Autowired some beans

    @EventListener
    public void run(ContextRefreshedEvent event) {
        this.call(new Class[]{
                CategoriesTableSeeder.class,
                RolesTableSeeder.class,
                UsersTableSeeder.class,
                ArticlesTableSeeder.class
                //some seeder class
        });
    }

}