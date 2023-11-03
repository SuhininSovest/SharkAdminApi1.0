package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.repository.RoleRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {
    private final RoleRepository roleRepository;

    public RoleController(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
}
