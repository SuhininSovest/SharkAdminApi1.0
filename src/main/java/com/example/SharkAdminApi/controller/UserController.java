package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.UserDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //Get List with User
    @GetMapping("/getUsers")
    List<User> all() {
        return userService.readUsersAll();
    }
    //Create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }
    //update user by id
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
    //get User by id
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<User> getUser(@PathVariable Long id) {
        return userService.readUserById(id);
    }
    //Delete user by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

