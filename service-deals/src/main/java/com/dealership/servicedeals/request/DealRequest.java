package com.dealership.servicedeals.request;

import com.dealership.servicedeals.service.DealService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DealRequest {
    private final DealService dealService;

    private final RestTemplate restTemplate;

    @RequestMapping("/deals/")
    public String deal() throws JsonParseException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is deal service");
        jsonObject.put("message_2", restTemplate.exchange("http://service-cars:8091/cars/", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("message_3", restTemplate.exchange("http://service-users:8092/users/", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("Resume", "All services in use now");
        return jsonObject.toString();
    }

    @Autowired
    public DealRequest(DealService dealService, RestTemplate restTemplate) {
        this.dealService = dealService;
        this.restTemplate = restTemplate;
    }
}