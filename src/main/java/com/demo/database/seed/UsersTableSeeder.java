package com.demo.database.seed;

import com.demo.entity.Role;
import com.demo.entity.User;
import com.demo.repository.RoleRepository;
import com.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UsersTableSeeder implements Seeder {

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run() {
        //Faker faker = new Faker(new Locale("vi"));
        Role roleAdmin = roleRepository.findByName(Role.ROLE_ADMIN);
        Role roleUser = roleRepository.findByName(Role.ROLE_USER);
        Role roleMod = roleRepository.findByName(Role.ROLE_MOD);
        List<User> users = new ArrayList<>();
        users.add(new User(
                null, "admin",
                passwordEncoder.encode("admin"),
                1, "admin", Collections.singletonList(roleAdmin))
        );
        users.add(new User(
                null, "user",
                passwordEncoder.encode("user"),
                1, "user", Arrays.asList(roleMod, roleUser))
        );
        userRepository.saveAll(users);
    }
}
