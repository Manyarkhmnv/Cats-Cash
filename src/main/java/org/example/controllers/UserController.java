package org.example.controllers;

import lombok.AllArgsConstructor;
import org.example.models.Users;
import org.example.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping(path = "/new-user")
    public void addUser(@RequestBody Users user) {
       userService.saveUser(user);
    }

}
