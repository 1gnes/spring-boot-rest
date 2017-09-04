package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @RequestMapping(value = "/add")
    public Role createRole(@RequestParam(value= "name") String name){
        Role role = new Role(name);
        return roleService.saveRole(role);
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteRole(@PathVariable Long id){
        Role role = roleService.getRoleById(id);
        if (role != null) {
            if (role.getUsers().size() > 0)
                return "Role is using by users";
            else  {
                roleService.deleteRoleById(id);
                return "Role " +role.toString() +" deleted";
            }

        }
        else
            return "Role not found";
    }

    @RequestMapping("/all")
    public Iterable<Role> allRoles(){
        return roleService.getAllRoles();
    }
}
