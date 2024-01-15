package com.example.SharkAdminApi.service;

import com.example.SharkAdminApi.dto.UserDTO;

import com.example.SharkAdminApi.model.User;
import com.example.SharkAdminApi.repository.UserRepository;
import com.ibm.icu.text.Transliterator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

import static org.aspectj.util.LangUtil.split;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public static final String CYRILLIC_TO_LATIN = "Cyrillic-Latin";

    //Create password with Encoder
    public String generatePassword() {
        // Укажите желаемые параметры пароля (длина, используемые символы)
        int length = 12;
        String allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()_+-=[]{};':\"\\|,.<>/?";

        // Сгенерируйте случайную строку пароля
        char[] passwordChars = new char[length];
        for (int i = 0; i < length; i++) {
            int randomIndex = (int) (Math.random() * allowedChars.length());
            passwordChars[i] = allowedChars.charAt(randomIndex);
        }

        return new String(passwordChars);
    }

    //Update password
    @Transactional
    public User updateUserPassword(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exist."));

        // Обновляем только пароль и шифруем
        user.setPassword(userDTO.getPassword());

        // ID остается неизменным
        return userRepository.save(user);
    }

    // Зашифруйте пароль
    // String encodedPassword = passwordEncoder.encode(new String(passwordChars));

    //Get all users
    public List<User> readUsersAll() {
        return userRepository.findAll();
    }
    @Transactional
    public void setBlockingById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exist."));
        user.setActive(false);  // Set blocking to true
    }

    @Transactional
    public void setUnBlockingById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exist."));
        user.setActive(true);  // Set blocking to false
    }

    //update user
    @Transactional
    public User update(UserDTO userDTO, Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User with id " + id + " does not exist."));

        // Обновляем только указанные поля
        user.setFullName(userDTO.getFullName());
        user.setEmployeePosition(userDTO.getEmployeePosition());
        user.setDepartment(userDTO.getDepartment());
        user.setPhoneWork(userDTO.getPhoneWork());
        user.setPhonePersonal(userDTO.getPhonePersonal());

        // ID остается неизменным
        return userRepository.save(user);
    }

    //get user by id
    public Optional<User> readUserById(Long userId) {
        return userRepository.findById(userId);
    }
    //create user
    @Transactional
    public User create(UserDTO userDTO) {
        // Создание полного имени из переданных данных
        String fullName = createFullName(userDTO.getFirstName(), userDTO.getLastName(), userDTO.getSurname());
        // Создание логина для Active Directory
        String logonName = createLogonName(fullName, 1);
        // Проверка на совпадение logonName
        if (isLogonNameExists(logonName)) {
            // Если logonName уже занят, то начинаем его переименовывать
            int counter = 2;
            while (isLogonNameExists(logonName)) {
                logonName = createLogonName(fullName, counter);
                counter++;
            }
        }

        return userRepository.save(User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .surname(userDTO.getSurname())
                .logonName(logonName)
                .fullName(fullName)
                .fullNameForVideoMeeting(fullName)
                .employeePosition(userDTO.getEmployeePosition())
                .department(userDTO.getDepartment())
                .mail(logonName + "@mail.com")                       //Затычка
                .phoneWork(validatePhone(userDTO.getPhoneWork()))
                .phonePersonal(validatePhone(userDTO.getPhonePersonal()))
                .password(generatePassword())
                .roles("USER")
                .active(true)
                .build());
    }

    //Проверяем телефонный номер
    public static String validatePhone(String text) {

        String phoneWork = text;

        // Удаляем все лишние символы
        phoneWork = phoneWork.replaceAll("[^0-9]", "");

        // Проверяем, что длина номера не меньше 10 цифр
        if (phoneWork.length() < 10) {
            throw new IllegalArgumentException("Рабочий телефон должен быть не менее 10 цифр");
        }

        // Проверяем, что добавочный номер (если есть) - это только цифры
        if (phoneWork.contains(" ")) {
            String[] parts = phoneWork.split(" ");
            if (parts.length > 2) {
                throw new IllegalArgumentException("Неверный формат рабочего телефона");
            }

            String addNumber = parts[1];
            if (!addNumber.matches("[0-9]+")) {
                throw new IllegalArgumentException("Добавочный номер должен состоять только из цифр");
            }
        }
        return text;
    }

    private boolean isLogonNameExists(String logonName) {
        // Проверяем, существует ли logonName в базе данных
        return userRepository.existsByLogonName(logonName);
    }

    public String createFullName(String firstName, String lastName, String surname) {
        // Если surname не задана, то просто возвращаем firstName и lastName
        if (surname == null || surname.isEmpty()) {
            return String.format("%s %s", lastName, firstName);
        } else {
            return String.format("%s %s %s", lastName, firstName, surname);
        }
    }
    //create Logon for AD and mail
    public String createLogonName(String fullName, int count) {
        Transliterator toLatinTrans = Transliterator.getInstance(CYRILLIC_TO_LATIN);
        String[] words = split(toLatinTrans.transliterate(fullName));
        int i = Math.min(count, words[words.length - 1].length());
        String result = words[0] + "." + words[1].substring(0, i) + words[2].substring(0, i);

        // Удаляем мягкий и твердый знак
        result = result.replaceAll("[ьъ]", "");

        // Удаляем другие лишние символы
        result = result.replaceAll("[^a-zA-Z0-9.]", "");

        return result;
    }

    //delete user
    @Transactional
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
