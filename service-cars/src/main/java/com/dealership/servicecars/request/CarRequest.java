package com.dealership.servicecars.request;

import com.dealership.servicecars.service.CarService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/cars")
public class CarRequest {

    private final CarService carService;

    private final RestTemplate restTemplate;

    @RequestMapping(value = "/")
    public String car() throws JsonParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is car service");
        return jsonObject.toString();
    }

    @Autowired
    public CarRequest(CarService carService, RestTemplate restTemplate) {
        this.carService = carService;
        this.restTemplate = restTemplate;
    }
}