package com.example.SharkAdminApi.dto;

import lombok.Data;

import javax.persistence.Column;
@Data
public class UserDTO {
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
}
