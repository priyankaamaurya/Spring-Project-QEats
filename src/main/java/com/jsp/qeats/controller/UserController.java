package com.jsp.qeats.controller;

import com.jsp.qeats.entity.User;
import com.jsp.qeats.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    // GET ALL USERS (Admin purpose)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    // GET USER BY ID
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id ));
    }

    // UPDATE USER
    @PutMapping("/{id}")
    public  User updateUser (@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // DELETE USER
    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }


}
