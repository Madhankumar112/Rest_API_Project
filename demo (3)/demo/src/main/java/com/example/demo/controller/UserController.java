package com.example.demo.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Services.UserService;
import com.example.demo.entity.User;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/sorted/name")
    public List<User> getUsersSortedByName() {
        return userService.getAllUsersSortedByName();
    }

    @GetMapping("/sorted")
    public List<User> getUsersSortedByField(@RequestParam String sortField) {
        return userService.getAllUsersSortedByField(sortField);
    }

    @GetMapping("/page")
    public Page<User> getUsersPage(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size) {
        return userService.getUsersPage(page, size);
    }

    @GetMapping("/sort")
    public List<User> getAllUsersSort(@RequestParam(defaultValue = "id") String sortBy) {
        return userService.getAllUsersSorted(sortBy);
    }
}
