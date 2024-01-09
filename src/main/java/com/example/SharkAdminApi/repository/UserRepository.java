package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLogonName(String logonName);
    Optional<User> findByLogonName(String logonName);

}

