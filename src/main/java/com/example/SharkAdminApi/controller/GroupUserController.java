package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.GroupUserDTO;
import com.example.SharkAdminApi.model.GroupUser;
import com.example.SharkAdminApi.service.GroupUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/groupUsers")
public class GroupUserController {

    private final GroupUserService groupUserService;

    @Autowired
    public GroupUserController(GroupUserService groupUserService) {
        this.groupUserService = groupUserService;
    }

    @GetMapping
    public List<GroupUser> all() {
        return groupUserService.readAllGroupUsers();
    }

    @GetMapping("/{id}")
    public Optional<GroupUser> getGroupUser(@PathVariable Long id) {
        return groupUserService.readGroupUserById(id);
    }

    @PostMapping
    public void createGroupUser(@RequestBody GroupUser groupUser) {
        groupUserService.createGroupUser(groupUser);
    }
}
