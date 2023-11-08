package com.example.SharkAdminApi.model;

import lombok.Builder;
import lombok.Data;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Builder
@Indexed
@Table(name = "table_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @Column(name="firstName")
    @Field
    private String firstName;
    @Column(name="lastName")
    @Field
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
    private boolean bloking = false;

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
