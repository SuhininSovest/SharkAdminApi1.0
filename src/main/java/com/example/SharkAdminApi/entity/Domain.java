package com.example.SharkAdminApi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "domain")
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nameDomain;

    @OneToMany(mappedBy = "domain")
    private List<GroupUser> groupList;
}
