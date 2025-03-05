package com.example.lab1.service;

import com.example.lab1.model.User;
import com.example.lab1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String username) {
        return userRepository.save(new User(null, username, 0));
    }

    public User getUser(Long id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Long id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll().values().stream().toList();
    }
    public User updateUser(Long id, String newUsername) {
        User user = userRepository.findById(id);
        if (user != null) {
            user.setUsername(newUsername);
        }
        return user;
    }

    public User updateUserScore(Long id, int newScore) {
        User user = userRepository.findById(id);
        if (user != null && newScore > user.getBestScore()) {
            user.setBestScore(newScore);
        }
        return user;
    }
}