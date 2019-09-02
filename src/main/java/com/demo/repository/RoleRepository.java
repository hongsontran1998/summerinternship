package com.demo.repository;

import com.demo.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository
        extends CrudRepository<Role, Integer> {
    Role findByName(String name);
}
