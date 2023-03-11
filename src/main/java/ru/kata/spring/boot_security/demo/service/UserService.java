package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();
    void addUser(User user);
    User getUserById(Long id);
    void updateUser(User updateUser);
    void deleteUser(Long id);
    User findByUsername(String username);
}
