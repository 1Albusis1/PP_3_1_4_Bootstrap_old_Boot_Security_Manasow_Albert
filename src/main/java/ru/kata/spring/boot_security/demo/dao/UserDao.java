package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.kata.spring.boot_security.demo.model.User;

public interface UserDao extends JpaRepository<User, Long> {
    @Query("select u from User u join fetch u.roles where u.username =(:username)")
    User findByUsername(String username);
}
