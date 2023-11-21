package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.UserDTO;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;


    //Get List with User
    @GetMapping("/get/all")
    List<User> getAllUsers() {
        return userService.readUsersAll();
    }
    //Create user
    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserDTO dto) {
        return new ResponseEntity<>(userService.create(dto), HttpStatus.CREATED);
    }
    //update user by id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        User updatedUser = userService.update(userDTO, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
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
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

