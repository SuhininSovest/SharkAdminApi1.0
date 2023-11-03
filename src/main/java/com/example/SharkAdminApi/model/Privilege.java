package com.example.SharkAdminApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Data
@Entity
@Table(name = "privilege")
public class Privilege {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long privilegesId;
    private String name;

    @ManyToMany(mappedBy = "privileges")
    private Collection<Role> role_privileges;
}
