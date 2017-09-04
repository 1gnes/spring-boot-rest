package com.example.demo.controller;

import com.example.demo.domain.Privilege;
import com.example.demo.service.PrivilegeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/privilege")
public class PrivilegeController {

    @Autowired
    PrivilegeService privilegeService;

    @RequestMapping("/{id}")
    public ResponseEntity<Privilege> getById(@PathVariable Long id){
        return  new ResponseEntity<Privilege>(privilegeService.getPrivilegeById(id), HttpStatus.OK);
    }

    @RequestMapping("/add")
    public ResponseEntity<Privilege> addPrivilege(@RequestParam String name)
    {
        Privilege privilege = new Privilege(name);
        return new ResponseEntity<Privilege>(privilegeService.savePrivilege(privilege), HttpStatus.OK);
    }

    @RequestMapping("/delete/{id}")
    public ResponseEntity<String> deletePrivilege(@PathVariable Long id){
        Privilege privilege = privilegeService.getPrivilegeById(id);
        if (privilege != null){
            if (privilege.getRoles().size() > 0){
                return new ResponseEntity<String>("Privilege is using by role(s)", HttpStatus.NOT_ACCEPTABLE);
            }
            else {
                privilegeService.deletePrivilegeById(id);
                return new ResponseEntity<String>("Privilege was deleted", HttpStatus.OK);
            }
        }
        else {
            return  new ResponseEntity<String>("Privilege not found", HttpStatus.OK);
        }
    }

    @RequestMapping("/all")
    public ResponseEntity<Iterable<Privilege>> allPrivileges(){
        return new ResponseEntity<Iterable<Privilege>>(privilegeService.getAllPrivileges(), HttpStatus.OK);
    }
}
