package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("")
    public String ShowAllUsers(Model model) {
        System.out.println("///GetMapping///ShowAllUsers///");
        model.addAttribute("users", userService.findAll());
        return "user-list";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user, Model model) {
        System.out.println("/GetMapping////////////////////////createUserForm////");
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAll());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user) {
        System.out.println("/PostMapping/////////////////////////createUser///");
        userService.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        System.out.println("///GetMapping//////////////////////updateUserForm////");
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("roles", roleService.findAll());
        return "user-update";
    }

    @PatchMapping("/user-update")
    public String updateUser(@ModelAttribute("user") User user) {
        System.out.println("///PatchMapping///////////////////////updateUser///");
        userService.save(user);
        return "redirect:/admin";
    }

    @DeleteMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        System.out.println("///DeleteMapping///////////////////////deleteUser///");
        userService.deleteById(id);
        return "redirect:/admin";
    }

}

