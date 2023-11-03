package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.repository.GroupUserRepisitory;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GroupUserController {
    private final GroupUserRepisitory groupUserRepisitory;

    public GroupUserController(GroupUserRepisitory groupUserRepisitory) {
        this.groupUserRepisitory = groupUserRepisitory;
    }
}
