package com.dealership.serviceusers.api;

import com.dealership.serviceusers.service.UserService;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<com.dealership.serviceusers.repo.model.User>> index(){
        final List<com.dealership.serviceusers.repo.model.User> users = userService.fetchAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{idUser}")
    public ResponseEntity<com.dealership.serviceusers.repo.model.User> show(@PathVariable Long idUser){
        try{
            final com.dealership.serviceusers.repo.model.User user = userService.fetchById(idUser);
            return ResponseEntity.ok(user);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.dealership.serviceusers.api.dto.User user){
        final String userType = user.getUserType();
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        final String phoneNumber = user.getPhoneNumber();
        final String login = user.getLogin();
        final String password = user.getPassword();

        final long idUser = userService.create(userType, firstname, lastname, email, phoneNumber, login, password);
        final String location = String.format("/users/%d", idUser);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{idUser}")
    public ResponseEntity<Void> update(@PathVariable Long idUser, @RequestBody com.dealership.serviceusers.api.dto.User user){
        final String userType = user.getUserType();
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();
        final String email = user.getEmail();
        final String phoneNumber = user.getPhoneNumber();
        final String login = user.getLogin();
        final String password = user.getPassword();
        try{
            userService.update(idUser, userType, firstname, lastname, email, phoneNumber, login, password);
            return ResponseEntity.noContent().build();
        }catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idUser}")
    public ResponseEntity<Void> delete(@PathVariable Long idUser){
        userService.delete(idUser);
        return ResponseEntity.noContent().build();
    }
}
