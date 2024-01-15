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
@RequestMapping("/api/users/")
public class UserController {

    private final UserService userService;


    // update user by id
    @PutMapping("/update/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO, @PathVariable Long userId) {
        User updatedUser = userService.update(userDTO, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    // update user password by id
    @PutMapping("/update/password/{userId}")
    public ResponseEntity<User> updateUserPassword(@RequestBody UserDTO userDTO, @PathVariable Long userId) {
        if (!userDTO.getPassword().equals(userDTO.getRepeatPassword())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST); // Сообщаем о несовпадении паролей
        }

        // Обновляем пароль пользователя
        User updatedUser = userService.updateUserPassword(userDTO, userId);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
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
            return "redirect:/";
        }
    }

}

