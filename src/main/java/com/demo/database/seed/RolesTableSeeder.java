package com.demo.database.seed;

import com.demo.entity.Role;
import com.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RolesTableSeeder implements Seeder {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public void run() {
        List<Role> roles = new ArrayList<>();
        roles.add(new Role(null, "ADMIN", null));
        roles.add(new Role(null, "USER", null));
        roles.add(new Role(null, "MOD", null));
        roleRepository.saveAll(roles);
    }
}
