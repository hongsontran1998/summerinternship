package com.demo.database.seed;

import com.demo.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class UsersTableSeeder implements Seeder {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run() {
        Faker faker = new Faker(new Locale("vi"));

    }
}
