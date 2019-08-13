package com.demo;

import com.demo.interceptor.ApplicationInterceptor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableScheduling
//@EnableAuthorizationServer //OAUTH2
//@EnableResourceServer //OAUTH2
public class Application implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("Tomcat have started");
    }


    //what is this? I have'nt known
    /*@Bean
    CommandLineRunner runner(){
        return args -> {
            System.out.println("CommandLineRunner running in the UnsplashApplication class...");
        };
    }*/
}
