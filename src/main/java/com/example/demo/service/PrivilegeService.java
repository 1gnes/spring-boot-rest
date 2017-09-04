package com.example.demo.service;

import com.example.demo.domain.Privilege;
import com.example.demo.domain.Role;

import java.util.Set;

public interface PrivilegeService {
    Iterable<Privilege> getAllPrivileges();
    Privilege savePrivilege(Privilege privilege);
    Privilege getPrivilegeById(Long id);
    Privilege getPrivilegeByName(String name);
    Set<Privilege> getPrivilegesByRole(Role role);
    void deletePrivilegeById(Long id);
}
