package com.example.controller;

import com.example.model.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user) {
        int result = userService.addUser(user);
        return result > 0 ? "User added successfully!" : "Failed to add user.";
    }

    @GetMapping("/callProcedure")
    public Map<String, Object> callStoredProcedure(@RequestParam int id) {
        return userService.executeStoredProcedure(id);
    }
}