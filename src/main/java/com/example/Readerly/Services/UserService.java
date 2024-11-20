package com.example.Readerly.Services;

import com.example.Readerly.Entities.User;
import com.example.Readerly.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String signUp(User user) {
        Optional<User> existingUser = userRepository.findById(user.getEmail());
        if (existingUser.isPresent()) {
            throw new DuplicateKeyException("Email is already in use.");
        }
        userRepository.save(user);
        return "User signed up successfully.";
    }
}
