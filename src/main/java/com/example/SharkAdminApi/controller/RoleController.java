package com.example.SharkAdminApi.controller;

import com.example.SharkAdminApi.dto.RoleDTO;
import com.example.SharkAdminApi.model.Role;
import com.example.SharkAdminApi.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/get/all")
    public List<Role> getAllRoles() {
        return roleService.readRoleAll();
    }

    @GetMapping("/get/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Optional<Role> getRole(@PathVariable Long id) {
        return roleService.readUserById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.createRole(role), HttpStatus.CREATED);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        roleService.delete(id);
    }
    @Transactional
    @PutMapping("/update/{id}")
    public void updateRole(@RequestBody RoleDTO roleDTO, @PathVariable Long id) {
        roleService.update(roleDTO, id);
    }

}
