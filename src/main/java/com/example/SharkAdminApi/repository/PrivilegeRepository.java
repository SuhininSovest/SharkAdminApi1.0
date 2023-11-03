package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.Privilege;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrivilegeRepository extends JpaRepository<Privilege, Long> {
}
