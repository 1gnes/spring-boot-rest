package com.example.demo.service;

import com.example.demo.domain.User;
import java.lang.Iterable;

public interface UserService {

    Iterable<User> getAllUsers();
    User getUserById(Long id);
    User getUserByEmail(String email);
    User saveUser(User user);
    void deleteUser(Long id);
}
