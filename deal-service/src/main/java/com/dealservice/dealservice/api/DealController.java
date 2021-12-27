package com.dealservice.dealservice.api;

import com.dealservice.dealservice.model.Deal;
import com.dealservice.dealservice.service.DealService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@RestController
public class DealController
{
    private final DealService dealService;

    private final RestTemplate restTemplate;

    @RequestMapping("/")
    public String deal() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is deal service");
        jsonObject.put("message_2", restTemplate.exchange("http://localhost:8081/", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("message_3", restTemplate.exchange("http://localhost:8080/", HttpMethod.GET, null, String.class).getBody());
        jsonObject.put("Resume", "All services in use now");
        return jsonObject.toString();
    }

    @Autowired
    public DealController(DealService dealService, RestTemplate restTemplate)
    {
        this.dealService = dealService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/deal")
    public ResponseEntity<List<Deal>> getdeals() {
        return ResponseEntity.ok(dealService.getdeals());
    }

    @PostMapping(value = "/deal")
    public ResponseEntity<Deal> postDeals(@Valid @RequestBody Deal newDeal)
    {
        return ResponseEntity.ok(dealService.saveDeal(newDeal));
    }

    @GetMapping(value = "/deal/{id_deal}")
    public ResponseEntity<Deal> getDeal(@PathVariable Long id_deal)
    {
        return ResponseEntity.ok(dealService.getDealById(id_deal));
    }

    @PutMapping(value = "/deal/{id_deal}")
    public ResponseEntity<Deal> updateDeal(@PathVariable Long id_deal, @Valid @RequestBody Deal updatedDeal)
    {
        return ResponseEntity.ok(dealService.updateDealById(id_deal, updatedDeal));
    }

    @PatchMapping("/deal/{id_deal}")
    public ResponseEntity<Void> updateDealPatch(@PathVariable long id_deal, @RequestBody Deal deal) {
        final String dealDate = deal.getDealDate();
        final String statusDeal = deal.getStatusDeal();

        try {
            dealService.updateDealPatch(id_deal, dealDate, statusDeal);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/deal/{id_deal}")
    public ResponseEntity<String> deleteDeal(@PathVariable Long id_deal)
    {
        return ResponseEntity.ok(dealService.deleteDealById(id_deal));
    }

}
