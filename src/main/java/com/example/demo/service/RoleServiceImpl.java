package com.example.demo.service;

import com.example.demo.domain.Role;
import com.example.demo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role getRoleByName(String name) { return roleRepository.getByName(name); }

    @Override
    public Iterable<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.delete(id);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findOne(id);
    }

    @Override
    public Role saveRole(Role role) { return roleRepository.save(role); }
}
