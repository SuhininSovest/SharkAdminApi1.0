package com.example.SharkAdminApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String surname;
    private String fullName;
    private String fullNameForVideoMeeting;
    private String employeePosition;
    private String department;
    private String mail;
    private String phoneWork;
    private String phonePersonal;
    private boolean bloking = false;

    @ManyToMany(mappedBy = "user")
    @JoinTable(
            name = "roles_users",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roleUserList;

    @ManyToMany(mappedBy = "usersInGroup")
    private List<GroupUser> groupUserList;
}
