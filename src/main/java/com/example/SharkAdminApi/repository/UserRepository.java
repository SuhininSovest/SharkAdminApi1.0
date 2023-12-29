package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogonName(String logonName);

}

