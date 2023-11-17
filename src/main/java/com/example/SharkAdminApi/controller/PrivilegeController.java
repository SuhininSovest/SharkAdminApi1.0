package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.DomainDTO;
import com.example.SharkAdminApi.dto.PrivilegeDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.model.Privilege;
import com.example.SharkAdminApi.service.PrivilegeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/privilege")
public class PrivilegeController {
    private final PrivilegeService privilegeService;

    //Get List with
    @GetMapping("/get")
    List<Privilege> all() {
        return privilegeService.readPrivilegeAll();
    }

    //Get one domain from list
    @GetMapping("/get/{privilegeId}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Privilege> readById(@PathVariable Long privilegeId) {
        return privilegeService.readPrivilegeById(privilegeId);
    }

    //Create domain
    @PostMapping("/privilege/create")
    public void createPrivilege(@RequestBody PrivilegeDTO dto) {
        new ResponseEntity<>(privilegeService.create(dto), HttpStatus.CREATED);
    }

    //delete domain
    @DeleteMapping("/privilege/delete/{id}")
    void deletePrivilege(@PathVariable Long id) {
        privilegeService.delete(id);
    }
}
