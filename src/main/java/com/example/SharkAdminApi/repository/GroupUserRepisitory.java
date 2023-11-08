package com.example.SharkAdminApi.repository;

import com.example.SharkAdminApi.model.GroupUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserRepisitory extends JpaRepository<GroupUser, Long> {
}
