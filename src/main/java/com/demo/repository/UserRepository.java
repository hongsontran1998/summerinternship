package com.demo.repository;

import com.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Query("select u from User u where u.username = :username")
    User findOneByUsername(@Param("username") String username);

    @Query("select u from User u where u.username = :username and u.active = :active")
    User findOneByUsernameAndStatus(String username, Integer active);
}
