package ru.kata.spring.boot_security.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;

@Repository
public interface RoleDao extends JpaRepository<Role, Long> {

    @Override
    @Query("select r from Role r join FETCH r.name")
    default List<Role> findAll() {
        return null;
    }
}
