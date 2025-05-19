package org.example.Registration.service;

import org.example.Registration.entity.User;
import org.example.Registration.repositories.UserRepository;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int id) {
        User user = userRepository.findById(id);
        return user != null ? user.getName() : "User not found";
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }
}
