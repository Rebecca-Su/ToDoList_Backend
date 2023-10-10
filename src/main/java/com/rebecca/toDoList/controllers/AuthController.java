package com.rebecca.toDoList.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rebecca.toDoList.dto.UserDto;
import com.rebecca.toDoList.services.UserService;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public ResponseEntity<UserDto> loginUser(@RequestBody UserDto user) {
        return new ResponseEntity<>(userService.login(user), HttpStatus.OK);
    }
}
