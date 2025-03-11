package com.starco.controller;

import com.starco.model.User;
import com.starco.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping("/api/users")
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }
    @GetMapping("/api/users")
    public List<User> getUser(){

        return userRepository.findAll();
    }
    @GetMapping("/api/users/{user_id}")
    public User getUserById(@PathVariable("user_id") Long id) throws Exception{
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new Exception("user not found");
    }

    
    @PutMapping ("/api/users/{id}")
    public User updateUser(@RequestBody User user,@PathVariable Long id) throws Exception{
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("User Not Found with Id :"+id);
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);
    }

    @DeleteMapping("/api/users/{id}")
    public String  deleteById(@PathVariable Long id) throws Exception{

        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new Exception("User Not Exist with id"+id);
        }
        userRepository.deleteById(id);
        return "User deleted successfully with id "+id;
    }

}
