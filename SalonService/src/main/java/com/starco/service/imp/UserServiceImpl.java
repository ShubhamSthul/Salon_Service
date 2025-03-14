package com.starco.service.imp;

import com.starco.exception.UserException;
import com.starco.model.User;
import com.starco.repository.UserRepository;
import com.starco.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

   private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isPresent()){
            return otp.get();
        }
        throw new UserException("user not found");
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(Long id) throws UserException {

        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User Not Exist with id"+id);
        }
        userRepository.deleteById(id);
    }


    @Override
    public User updateUser(Long id, User user) throws UserException {
        Optional<User> otp = userRepository.findById(id);
        if(otp.isEmpty()){
            throw new UserException("User Not Found with Id :"+id);
        }
        User existingUser = otp.get();
        existingUser.setFullName(user.getFullName());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());

        return userRepository.save(existingUser);

    }
}
