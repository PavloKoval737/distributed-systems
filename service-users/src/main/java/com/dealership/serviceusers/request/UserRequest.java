package com.dealership.serviceusers.request;

import com.dealership.serviceusers.service.UserService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserRequest {

    private final UserService userService;

    private final RestTemplate restTemplate;

    @RequestMapping(value="/")
    public String car() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is user service");
        return jsonObject.toString();
    }

    @Autowired
    public UserRequest(UserService userService, RestTemplate restTemplate)
    {
        this.userService = userService;
        this.restTemplate = restTemplate;
    }
}