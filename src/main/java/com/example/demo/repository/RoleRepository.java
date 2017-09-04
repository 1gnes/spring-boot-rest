package com.example.demo.repository;

import com.example.demo.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{

    Role getByName(String name);
}
