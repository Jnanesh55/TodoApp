package com.example.TodoApp.Controller;

import com.example.TodoApp.Model.User;
import com.example.TodoApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable String username){
        return userService.findByUsername(username);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user){
        return userService.registerUser(user);
    }
}
