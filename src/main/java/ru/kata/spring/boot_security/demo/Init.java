//package ru.kata.spring.boot_security.demo;
//
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Component;
//import ru.kata.spring.boot_security.demo.model.Role;
//import ru.kata.spring.boot_security.demo.model.User;
//import ru.kata.spring.boot_security.demo.service.RoleService;
//import ru.kata.spring.boot_security.demo.service.UserService;
//
//import javax.annotation.PostConstruct;
//import java.util.HashSet;
//import java.util.Set;
//
//@Component
//public class Init {
//    private final UserService userService;
//    private final RoleService roleService;
//    private final PasswordEncoder passwordEncoder;
//
//    public Init(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
//        this.userService = userService;
//        this.roleService = roleService;
//        this.passwordEncoder = passwordEncoder;
//    }
//    //Альберт, С ДНЕМ РОЖДЕНИЯ!!!!!!!
//
//    @PostConstruct
//    public void initializeDB() {
//        Role roleAdmin = new Role("ROLE_ADMIN");
//        Role roleUser = new Role("ROLE_USER");
//
//        Set<Role> roleAdminSet = new HashSet<>();
//        Set<Role> roleUserSet = new HashSet<>();
//
//        roleAdminSet.add(roleAdmin);
//        roleUserSet.add(roleUser);
//
//        User admin = new User("admin", "admin",
//                "admin", passwordEncoder.encode("admin"),  roleAdminSet);
//
//        User user = new User("user", "user",
//                "user", passwordEncoder.encode("user"), roleUserSet);
//
//        roleService.addRole(roleAdmin);
//        roleService.addRole(roleUser);
//        userService.addUser(admin);
//        userService.addUser(user);
//    }
//}
