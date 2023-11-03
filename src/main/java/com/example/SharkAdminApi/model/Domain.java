package com.example.SharkAdminApi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId;
    private String nameDomain;
    @OneToMany
    @JoinColumn(name = "GroupUser")
    private List<GroupUser> groupUserList;
}
