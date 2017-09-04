package com.example.demo.repository;


import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User getByEmail(String email);
    Set<User> getUsersByRoles(Role role);
}
