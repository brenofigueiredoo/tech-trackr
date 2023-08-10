package com.breno.techtrackr.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.breno.techtrackr.dto.UserDto;
import com.breno.techtrackr.exception.AppException;
import com.breno.techtrackr.model.User;
// import com.breno.techtrackr.model.UserRole;
import com.breno.techtrackr.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private void checkEmailAndCpf(final UserDto userData) {

        if (userRepository.existsUserByEmail(userData.getEmail())) {
            throw new AppException("Email Already In Use", HttpStatus.CONFLICT);
        }

    }

    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public User createUser(final UserDto userData) {

        checkEmailAndCpf(userData);

        userData.setPassword(passwordEncoder().encode(userData.getPassword()));
        System.out.println(userData.getEmail());
        final User user = new User(
                userData.getName(),
                userData.getEmail(),
                userData.getPassword(),
                userData.getBio(),
                userData.getContact(),
                userData.getModule(),
                userData.getRole());

        return userRepository.save(user);

    }

    public List<User> readUsers() {
        final List<User> users = userRepository.findAll();

        return users;
    }

    public User retrieveUser(final long id) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        return foundUser;
    }

    public User updateUser(final UserDto userData, final long id) {
        checkEmailAndCpf(userData);

        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        String nameToSet = userData.getName() == null ? foundUser.getName() : userData.getName();
        String emailToSet = userData.getEmail() == null ? foundUser.getEmail() : userData.getEmail();
        String passwordToSet = userData.getPassword() == null ? foundUser.getPassword() : userData.getPassword();
        String bioToSet = userData.getBio() == null ? foundUser.getBio() : userData.getBio();
        String contactToSet = userData.getContact() == null ? foundUser.getContact() : userData.getContact();
        String moduleToSet = userData.getModule() == null ? foundUser.getModule() : userData.getModule();

        foundUser.setName(nameToSet);
        foundUser.setEmail(emailToSet);
        foundUser.setPassword(passwordToSet);
        foundUser.setBio(bioToSet);
        foundUser.setContact(contactToSet);
        foundUser.setModule(moduleToSet);

        return userRepository.save(foundUser);
    }

    public void deleteUser(final long id) {
        final User foundUser = userRepository.findById(id)
                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));

        userRepository.delete(foundUser);
    }

}
