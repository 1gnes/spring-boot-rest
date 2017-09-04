package com.example.demo.service;

import com.example.demo.domain.Privilege;
import com.example.demo.domain.Role;
import com.example.demo.repository.PrivilegeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

    @Autowired
    PrivilegeRepository privilegeRepository;

    @Override
    public Iterable<Privilege> getAllPrivileges() {
        return privilegeRepository.findAll();
    }

    @Override
    public Privilege savePrivilege(Privilege privilege) {
        return privilegeRepository.save(privilege);
    }

    @Override
    public Privilege getPrivilegeById(Long id) {
        return privilegeRepository.findOne(id);
    }

    @Override
    public Privilege getPrivilegeByName(String name) {
        return privilegeRepository.getByName(name);
    }

    @Override
    public Set<Privilege> getPrivilegesByRole(Role role) {
        return privilegeRepository.getPrivilegesByRoles(role);
    }

    @Override
    public void deletePrivilegeById(Long id) {
        privilegeRepository.delete(id);
    }
}
