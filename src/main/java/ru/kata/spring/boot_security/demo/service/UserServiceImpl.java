package ru.kata.spring.boot_security.demo.service;

import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl  implements UserService, UserDetailsService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserDao userDao, @Lazy PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    @Transactional
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public User getUserById(Long id) {
        Optional<User> userGetById = userDao.findById(id);
        if (userGetById.isPresent()) {
            return userGetById.get();
        } else {
            throw new UsernameNotFoundException(String.format("Пользователь с id '%s' не найден", id));
        }
    }

    @Override
    @Transactional
    public void updateUser(User updateUser) {
        updateUser.setPassword(passwordEncoder.encode(updateUser.getPassword()));
        userDao.save(updateUser);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("/////////////////////");
        User user = userDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("Пользователь '%s' не найдет", username));
        }
        return user;
    }
}
