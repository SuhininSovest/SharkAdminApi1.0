package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.UserDTO;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.repository.UserRepository;
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
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    //Get List with User
    @GetMapping("/getAll")
    List<User> all() {
        return userRepository.findAll();
    }
    //Create user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.createUser(dto), HttpStatus.CREATED);
    }
    //update user by id
    @PutMapping("/update/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void updateUser(@RequestBody User user) {
        userService.updateUser(user);
    }
    //get User by id
    @GetMapping("/get/{userId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<User> getUser(@PathVariable Long userId) {
        return userService.readUserById(userId);
    }
    //Delete user by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

