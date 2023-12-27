package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.UserDTO;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // update user by id
    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long id) {
        User updatedUser = userService.update(userDTO, id);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    // Create user
    @PostMapping(value = "/newUser/create/", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createNewUser(@ModelAttribute UserDTO userDto) {
        userService.create(userDto); // Create the user in the service
        return "redirect:/api/users/get/all"; // Redirect to the users list after successful creation
    }

    @GetMapping("/create")
    public String userModel(@ModelAttribute("user") UserDTO userDto) {
        return "CreateUser";
    }
    @GetMapping("/get/all")  // Map to the correct path for displaying users
    public String showUserList(Model model) {
        model.addAttribute("users", userService.readUsersAll());
        // Add an empty User object for form binding
        model.addAttribute("user", new User());
        return "UserManagement";
    }

    //get User by id
    @GetMapping("/get/{userId}")
    public String getUserCard(@PathVariable Long userId, Model model) {
        Optional<User> userOptional = userService.readUserById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            model.addAttribute("user", user);
            return "UserCard";
        } else {
            return "redirect:/api/users/get/all";
        }
    }
    //Delete user by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

