package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.domain.User;
import java.lang.Iterable;
import java.util.Set;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User saveUser(User user);
    void deleteUser(Long id);
    Set<User> getUsersByRoles(Role role);
}
