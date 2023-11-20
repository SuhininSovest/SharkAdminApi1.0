package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.GroupUserDTO;
import com.example.SharkAdminApi.model.GroupUser;
import com.example.SharkAdminApi.service.GroupUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/groupUsers")
public class GroupUserController {

    private final GroupUserService groupUserService;

    @GetMapping("/all")
    public List<GroupUser> all() {
        return groupUserService.readAllGroupUsers();
    }

    @GetMapping("/get/{id}")
    public Optional<GroupUser> getGroupUser(@PathVariable Long id) {
        return groupUserService.readGroupUserById(id);
    }
    @Transactional
    @PostMapping("/create")
    public void createGroupUser(@RequestBody GroupUser groupUser) {
        groupUserService.createGroupUser(groupUser);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteGroupUser(@PathVariable Long id) {
        groupUserService.delete(id);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public void updateGroupUser(@PathVariable GroupUserDTO groupUserDTO, Long id){
        groupUserService.update(groupUserDTO, id);
    }
}
