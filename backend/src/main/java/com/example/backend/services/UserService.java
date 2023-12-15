package com.example.backend.services;

import com.example.backend.entities.User;
import com.example.backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Object getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public List<Object[]> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }
}
