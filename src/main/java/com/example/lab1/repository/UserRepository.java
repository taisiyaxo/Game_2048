package com.example.lab1.repository;

import com.example.lab1.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final Map<Long, User> users = new ConcurrentHashMap<>();
    private long currentId = 1;

    public User save(User user) {
        user.setId(currentId++);
        users.put(user.getId(), user);
        return user;
    }

    public User findById(Long id) {
        return users.get(id);
    }

    public void delete(Long id) {
        users.remove(id);
    }

    public Map<Long, User> findAll() {
        return users;
    }
}
