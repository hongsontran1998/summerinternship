package com.demo;

import com.demo.service.StorageProperties;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@SpringBootApplication
@EnableScheduling
//@EnableAuthorizationServer //OAUTH2
//@EnableResourceServer //OAUTH2
@EnableConfigurationProperties(StorageProperties.class)
public class Application implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Tomcat have started");
    }

    @Bean
    public CommonsMultipartResolver multipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        //resolver.setMaxUploadSize(5242880);
        return resolver;
    }


    //what is this? I have'nt known
    /*@Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("CommandLineRunner running in the UnsplashApplication class...");
        };
    }*/
}
