package com.example.demo.controller;

import com.example.demo.domain.Role;
import com.example.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable Long id){
        return  new ResponseEntity<Role>(roleService.getRoleById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/add")
    public ResponseEntity<Role> createRole(@RequestParam(value= "name") String name){
        Role role = new Role(name);
        return new ResponseEntity<Role>(roleService.saveRole(role), HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}")
    public ResponseEntity<String> deleteRole(@PathVariable Long id){
        Role role = roleService.getRoleById(id);
        if (role != null) {
            if (role.getUsers().size() > 0)
                return new ResponseEntity<String>("Role is using by users", HttpStatus.NOT_ACCEPTABLE);
            else  {
                roleService.deleteRoleById(id);
                return new ResponseEntity<String>("Role was deleted", HttpStatus.OK);
            }

        }
        else
            return new ResponseEntity<String>("Role not found", HttpStatus.OK);
    }

    @RequestMapping("/all")
    public ResponseEntity<Iterable<Role>> allRoles(){
        return new ResponseEntity<Iterable<Role>>(roleService.getAllRoles(), HttpStatus.OK);
    }
}
