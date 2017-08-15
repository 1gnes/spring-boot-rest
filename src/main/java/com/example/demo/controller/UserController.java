package com.example.demo.controller;

import com.example.demo.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

        @RequestMapping("/user")
        public User user(@RequestParam(value = "name", defaultValue = "Faruk") String name){
            return new User((long)(Math.random()*100), name);
        }

}
