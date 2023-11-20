package com.example.SharkAdminApi.service;

import com.example.SharkAdminApi.dto.GroupUserDTO;
import com.example.SharkAdminApi.model.GroupUser;
import com.example.SharkAdminApi.repository.GroupUserRepisitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class GroupUserService {

    private final GroupUserRepisitory groupUserRepisitory;

    @Autowired
    public GroupUserService(GroupUserRepisitory groupUserRepisitory) {
        this.groupUserRepisitory = groupUserRepisitory;
    }

    public List<GroupUser> readAllGroupUsers() {
        return groupUserRepisitory.findAll();
    }

    public Optional<GroupUser> readGroupUserById(Long id) {
        return groupUserRepisitory.findById(id);
    }

    public void createGroupUser(GroupUser groupUser) {
        groupUserRepisitory.save(groupUser);
    }
    public void delete(Long id) {
        groupUserRepisitory.deleteById(id);
    }
    public void update(GroupUserDTO groupUserDTO, Long id){
        GroupUser groupUser = groupUserRepisitory.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("GroupUser with id " + id + " does not exist."));
        groupUser.setGroupUserName(groupUserDTO.getGroupUserName());
        groupUserRepisitory.save(groupUser);
    }

}
