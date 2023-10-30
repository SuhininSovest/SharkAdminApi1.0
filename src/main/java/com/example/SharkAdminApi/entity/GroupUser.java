package com.example.SharkAdminApi.entity;

import jakarta.persistence.*;


import java.util.List;
@Entity
@Table(name = "groupUser")
public class GroupUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;

    private String domainName;
    private List<User> usersInGroup;

}
