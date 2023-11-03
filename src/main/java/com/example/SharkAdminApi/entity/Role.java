package com.example.SharkAdminApi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
@Data
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long roleId;
    private String roleName;

    @ManyToMany
    @JoinTable(
            name = "role_privileges",
            joinColumns = @JoinColumn(name = "role_privileges_id"),
            inverseJoinColumns = @JoinColumn(name = "privileges_id")
    )
    private List<Privilege> privileges;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;

}
