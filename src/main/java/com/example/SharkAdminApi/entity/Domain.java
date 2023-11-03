package com.example.SharkAdminApi.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long domainId;
    private String nameDomain;
    @OneToMany
    @JoinColumn(name = "GroupUser")
    private List<GroupUser> groupUserList;
}
