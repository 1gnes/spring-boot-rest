package com.example.demo.service;

import com.example.demo.domain.Role;
import org.springframework.stereotype.Service;

public interface RoleService {
    Iterable<Role> getAllRoles();
    Role saveRole(Role role);
    Role getRoleById(Long id);
    Role getRoleByName(String name);
    void deleteRoleById(Long id);
}
