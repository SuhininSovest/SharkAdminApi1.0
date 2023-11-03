package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
