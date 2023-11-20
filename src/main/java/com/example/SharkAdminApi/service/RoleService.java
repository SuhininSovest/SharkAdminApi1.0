package com.example.SharkAdminApi.service;

import com.example.SharkAdminApi.dto.RoleDTO;
import com.example.SharkAdminApi.model.Role;
import com.example.SharkAdminApi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> readRoleAll() {
        return roleRepository.findAll();
    }

    public Optional<Role> readUserById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }
    public void update (RoleDTO roleDTO, Long id) {
        Role role = roleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Privilege with id " + id + " does not exist."));
                role.setRoleName((roleDTO.getRoleName()));
    }
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }
}