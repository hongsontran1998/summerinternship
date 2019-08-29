package com.demo.database.seeds;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;


@Component
public class SeedingRunner {

    @Autowired
    ApplicationContext applicationContext;

    private static final String RUNNING_METHOD_NAME = "run";

    void call(Class<?>[] seederClasses) {
        try {
            if (seederClasses != null && seederClasses.length > 0) {
                for (Class<?> clazz : seederClasses) {
                    String beanName = clazz.getSimpleName();
                    beanName = beanName.substring(0, 1).toLowerCase() + beanName.substring(1);
                    //Object obj = clazz.newInstance(); //can not auto wired => Null Pointer Exception
                    Object obj = applicationContext.getBean(beanName);
                    clazz.getDeclaredMethod(RUNNING_METHOD_NAME, new Class[]{}).invoke(obj, new Object[]{});
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
