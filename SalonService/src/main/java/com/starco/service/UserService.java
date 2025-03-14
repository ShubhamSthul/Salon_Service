package com.starco.service;

import com.starco.exception.UserException;
import com.starco.model.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    User getUserById(Long id) throws UserException;
    List<User> getAllUser();
    void deleteUser(Long id) throws UserException;
    User updateUser(Long id, User user) throws UserException;

}
