package com.cgi.cinemabackend.controller;

import com.cgi.cinemabackend.dto.UserDTO;
import com.cgi.cinemabackend.models.User;
import com.cgi.cinemabackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public UserDTO loginUser(@RequestBody User user){
        return userService.login(user);
    }
}
