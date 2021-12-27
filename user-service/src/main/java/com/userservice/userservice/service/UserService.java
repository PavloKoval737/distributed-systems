package com.userservice.userservice.service;

import com.userservice.userservice.exception.UserNotFoundException;
import com.userservice.userservice.model.User;
import com.userservice.userservice.repo.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getusers() {
        return userRepository.findAll();
    }

    public User saveUser(User newUser) {
        return userRepository.save(newUser);
    }

    public User getUserById(Long id_user) {
        Optional<User> user = userRepository.findById(id_user);
        if (user.isPresent()) {
            log.info("user: {}", user.get());
            return user.get();
        }
        throw new UserNotFoundException();
    }

    public User updateUserById(Long id_user, User updatedUser) {
        Optional<User> user = userRepository.findById(id_user);
        if (user.isPresent()) {
            User oldUser = user.get();
            log.info("user: {}", oldUser);
            updateUser(oldUser, updatedUser);
            return userRepository.save(oldUser);
        }
        throw new UserNotFoundException();
    }

    private void updateUser(User oldUser, User updatedUser) {
        oldUser.setUserType(updatedUser.getUserType());
        oldUser.setFirstname(updatedUser.getFirstname());
        oldUser.setLastname(updatedUser.getLastname());
        oldUser.setEmail(updatedUser.getEmail());
        oldUser.setPhoneNumber(updatedUser.getPhoneNumber());
        oldUser.setLogin(updatedUser.getLogin());
        oldUser.setPassword(updatedUser.getPassword());
    }

    public void updateUserPatch(long id_user, String userType, String firstname, String lastname) throws IllegalArgumentException{
        final Optional<User> someUser = userRepository.findById(id_user);
        if (someUser.isEmpty()) throw new IllegalArgumentException("User not found");

        final User user = someUser.get();
        if (userType != null && !userType.isBlank()) user.setUserType(userType);
        if (firstname != null && !firstname.isBlank()) user.setFirstname(firstname);
        if (lastname != null && !lastname.isBlank()) user.setLastname(lastname);
        userRepository.save(user);
    }

    public String deleteUserById(Long id_user) {
        userRepository.deleteById(id_user);
        return "User was successfully deleted!";
    }

}