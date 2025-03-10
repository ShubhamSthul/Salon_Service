package com.starco.controller;

import com.starco.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/api/users")
    public User getUser(){
        User user = new User();
        user.setEmail("starco@gmail.com");
        user.setFullName("stacorporation");
        user.setPhone("9258974631");
        user.setRole("customer");
        return user;
    }

}
