package com.example.SharkAdminApi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long domainId;
    private String nameDomain;
    @OneToMany
    @JoinColumn(name = "GroupUser")
    private List<GroupUser> groupUserList;
}
