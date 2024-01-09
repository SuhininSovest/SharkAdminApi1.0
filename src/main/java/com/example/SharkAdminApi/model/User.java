package com.example.SharkAdminApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Indexed
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name="firstName")
    @Field
    private String firstName;
    @Column(name="lastName")
    @Field
    private String lastName;
    @Column(name="surname")
    private String surname;
    @Field
    @Column(name="logonName")
    private String logonName;
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
    @Column(name="active")
    private boolean active;
    @Column(name="password")
    private String password;
    @Column(name="rolesWebSecurity")
    private String rolesWebSecurity;
    @Column(name="user_roles")
    private String roles;
}
