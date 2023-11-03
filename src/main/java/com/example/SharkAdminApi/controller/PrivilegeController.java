package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.repository.PrivilegeRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrivilegeController {
    private final PrivilegeRepository privilegeRepository;

    public PrivilegeController(PrivilegeRepository privilegeRepository) {
        this.privilegeRepository = privilegeRepository;
    }
}
