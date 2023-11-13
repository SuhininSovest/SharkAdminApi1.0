package com.example.SharkAdminApi.service;

import com.example.SharkAdminApi.dto.UserDTO;
import com.example.SharkAdminApi.model.Domain;
import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    //Get all users
    public List<User> readUsersAll() {
        return userRepository.findAll();
    }
    //get user by id
    public Optional<User> readUserById(Long userId) {
        return userRepository.findById(userId);
    }
    //create user
    @Transactional
    public User createUser(UserDTO userDTO) {
        // Создание полного имени из переданных данных
        String fullName = String.format("%s %s %s", userDTO.getFirstName(), userDTO.getLastName(), userDTO.getSurname());

        return userRepository.save(User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .surname(userDTO.getSurname())
                // Применение созданного полного имени
                .fullName(fullName)
                // Применение полного имени для видеособрания из полного имени
                .fullNameForVideoMeeting(fullName)
                .employeePosition(userDTO.getEmployeePosition())
                .department(userDTO.getDepartment())
                .mail(userDTO.getMail())
                .phoneWork(userDTO.getPhoneWork())
                .phonePersonal(userDTO.getPhonePersonal())
                .build());
    }
    //update user
    @Transactional
    public User updateUser(User user) {
        return userRepository.save(user);
    }
    //delete user
    @Transactional
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
//    @Transactional
//    private void fillUserFromDto(User user, UserDTO userDTO) {
//        user.setFirstName(userDTO.getFirstName());
//        user.setLastName(userDTO.getLastName());
//        user.setSurname(userDTO.getSurname());
//        user.setFullName(userDTO.getFullName());
//        user.setFullNameForVideoMeeting(userDTO.getFullNameForVideoMeeting());
//        user.setEmployeePosition(userDTO.getEmployeePosition());
//        user.setDepartment(userDTO.getDepartment());
//        user.setMail(userDTO.getMail());
//        user.setPhoneWork(userDTO.getPhoneWork());
//        user.setPhonePersonal(userDTO.getPhonePersonal());
//    }
//    @Transactional
//    private UserDTO convertToUserDTO(User user) {
//        UserDTO userDTO = new UserDTO();
//        userDTO.setFirstName(user.getFirstName());
//        userDTO.setLastName(user.getLastName());
//        userDTO.setSurname(user.getSurname());
//        userDTO.setFullName(user.getFullName());
//        userDTO.setFullNameForVideoMeeting(user.getFullNameForVideoMeeting());
//        userDTO.setEmployeePosition(user.getEmployeePosition());
//        userDTO.setDepartment(user.getDepartment());
//        userDTO.setMail(user.getMail());
//        userDTO.setPhoneWork(user.getPhoneWork());
//        userDTO.setPhonePersonal(user.getPhonePersonal());
//        return userDTO;
//    }
}
