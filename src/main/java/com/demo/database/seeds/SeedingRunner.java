package com.demo.database.seeds;

import com.demo.controller.web.AuthController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;


@Component
public class SeedingRunner {

    @Autowired
    ApplicationContext applicationContext;

    private static final String RUNNING_METHOD_NAME = "run";

    private static final Logger LOGGER = LoggerFactory.getLogger(SeedingRunner.class);

    /*
        1. Iterate array seeder class
        2. Call run method of the class implemented Seeder interface
     */
    void call(Class<?>[] seederClasses) {
        try {
            if (seederClasses != null && seederClasses.length > 0) {
                for (Class<?> clazz : seederClasses) {
                    String beanName = clazz.getSimpleName();
                    beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
                    //CategoriesTableSeeder => bean name: categoriesTableSeeder
                    Object obj = applicationContext.getBean(beanName);
                    //Object obj = clazz.newInstance(); //can not auto wired => Null Pointer Exception
                    LOGGER.info("seeding " + clazz.getSimpleName());
                    clazz.getDeclaredMethod(RUNNING_METHOD_NAME, new Class[]{}).invoke(obj, new Object[]{});
                    LOGGER.info("seeded " + clazz.getSimpleName());
                    LOGGER.info("===========================");

                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
