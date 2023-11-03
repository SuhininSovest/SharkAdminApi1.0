package com.example.SharkAdminApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "table_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="surname")
    private String surname;
    @Column(name="fullName")
    private String fullName;
    @Column(name="fullNameForVideoMeetin")
    private String fullNameForVideoMeeting;
    @Column(name="employeePosition")
    private String employeePosition;
    @Column(name="department")
    private String department;
    @Column(name="mail")
    private String mail;
    @Column(name="phoneWork")
    private String phoneWork;
    @Column(name="phonePersonal")
    private String phonePersonal;
    @Column(name="bloking")
    private boolean bloking;

    @ManyToMany(mappedBy = "users")
    private List<GroupUser> groupUsers;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = @JoinColumn(name = "user_role_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<Role> roles;
}
