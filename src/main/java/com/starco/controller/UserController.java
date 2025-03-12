package com.starco.controller;

import com.starco.exception.UserException;
import com.starco.model.User;
import com.starco.repository.UserRepository;
import com.starco.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {


    private final UserService userService;

    @PostMapping("/api/users")
    public ResponseEntity<User> createUser(@RequestBody @Valid User user) {
        User createdUser = userService.createUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<User>> getUser() {
        List<User> user = userService.getAllUser();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/api/users/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable("user_id") Long id) throws Exception {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


    @PutMapping("/api/users/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws Exception {
        User updatedUser = userService.updateUser(id,user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/api/users/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) throws Exception {
         userService.deleteUser(id);
        return new ResponseEntity<>("User Deleted", HttpStatus.ACCEPTED);

    }
}
