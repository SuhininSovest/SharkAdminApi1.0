package com.example.SharkAdminApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class GroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long groupUserId;
    private String groupUserName;

    @ManyToMany
    @JoinTable(name = "group_user_user",
            joinColumns = @JoinColumn(name = "group_user_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
}
