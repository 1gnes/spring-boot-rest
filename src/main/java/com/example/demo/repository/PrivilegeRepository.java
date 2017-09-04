package com.example.demo.repository;

import com.example.demo.domain.Privilege;
import com.example.demo.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PrivilegeRepository  extends CrudRepository<Privilege, Long>{

    Privilege getByName(String name);
    Set<Privilege> getPrivilegesByRoles(Role role);
}
