package com.dealership.serviceusers.service;

import com.dealership.serviceusers.repo.UserRepo;
import com.dealership.serviceusers.repo.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class UserService {

    private final UserRepo userRepo;

    public List<User> fetchAll(){
        return userRepo.findAll();
    }

    public User fetchById(Long idUser) throws IllegalArgumentException{
        final Optional<User> maybeUser = userRepo.findById(idUser);

        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");
        else return maybeUser.get();
    }

    public long create(String userType, String firstname, String lastname,
                       String email, String phoneNumber, String login, String password)
    {
        final User user = new User(userType, firstname, lastname, email, phoneNumber, login, password);
        final User savedUser = userRepo.save(user);

        return savedUser.getIdUser();
    }

    public void update(Long idUser, String userType, String firstname, String lastname,
                       String email, String phoneNumber, String login, String password) throws IllegalArgumentException
    {
        final Optional<User> maybeUser = userRepo.findById(idUser);
        if (maybeUser.isEmpty()) throw new IllegalArgumentException("User not found");

        final User user = maybeUser.get();
        if(userType != null && !userType.isBlank()) user.setUserType(userType);
        if(firstname != null && !firstname.isBlank()) user.setFirstname(firstname);
        if(lastname != null && !lastname.isBlank()) user.setLastname(lastname);
        if(email != null && !email.isBlank()) user.setEmail(email);
        if(phoneNumber != null && !phoneNumber.isBlank()) user.setPhoneNumber(phoneNumber);
        if(login != null && !login.isBlank()) user.setLogin(login);
        if(password != null && !password.isBlank()) user.setPassword(password);
        userRepo.save(user);
    }

    public void delete(Long idUser)
    {
        userRepo.deleteById(idUser);
    }

}
