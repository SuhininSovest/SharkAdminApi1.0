package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleRepository extends JpaRepository<Role, Long> {
}
