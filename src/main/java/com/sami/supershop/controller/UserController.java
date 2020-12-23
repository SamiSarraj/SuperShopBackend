package com.sami.supershop.controller;

import com.sami.supershop.domain.User;
import com.sami.supershop.dto.UserDto;
import com.sami.supershop.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @PostMapping("/addCustomer")
    public ResponseEntity addNewCustomer(@RequestBody UserDto userDto) {
        userService.addCustomer(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/addAdmin")
    public ResponseEntity addNewAdmin(@RequestBody UserDto userDto) {
        userService.addAdmin(userDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{username}")
    public ResponseEntity deleteUser(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user == null) return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No such User");
        userService.deleteUser(user);
        return new ResponseEntity(HttpStatus.OK);
    }
}
