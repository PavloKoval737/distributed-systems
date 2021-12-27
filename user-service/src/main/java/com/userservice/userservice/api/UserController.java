package com.userservice.userservice.api;


import com.userservice.userservice.model.User;
import com.userservice.userservice.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController
{
    private final UserService userService;

    private final RestTemplate restTemplate;

    @RequestMapping(value="/")
    public String user() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is user service");
        return jsonObject.toString();
    }

    @Autowired
    public UserController(UserService userService, RestTemplate restTemplate)
    {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> getusers() {
        return ResponseEntity.ok(userService.getusers());
    }

    @PostMapping(value = "/user")
    public ResponseEntity<User> postUsers(@Valid @RequestBody User newUser) {
        return ResponseEntity.ok(userService.saveUser(newUser));
    }

    @GetMapping(value = "/user/{id_user}")
    public ResponseEntity<User> getUser(@PathVariable Long id_user) {
        return ResponseEntity.ok(userService.getUserById(id_user));
    }

    @PutMapping(value = "/user/{id_user}")
    public ResponseEntity<User> updateUser(@PathVariable Long id_user, @Valid @RequestBody User updatedUser) {
        return ResponseEntity.ok(userService.updateUserById(id_user, updatedUser));
    }

    @PatchMapping("/user/{id_user}")
    public ResponseEntity<Void> updateUserPatch(@PathVariable long id_user, @RequestBody User user) {
        final String userType = user.getUserType();
        final String firstname = user.getFirstname();
        final String lastname = user.getLastname();

        try {
            userService.updateUserPatch(id_user, userType, firstname, lastname);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/user/{id_user}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id_user) {
        return ResponseEntity.ok(userService.deleteUserById(id_user));
    }

}
