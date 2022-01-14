package com.dealership.servicedeals.api;

import com.dealership.servicedeals.service.DealService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/deals")
public class DealController {

    private final DealService dealService;
    @GetMapping
    public ResponseEntity<List<com.dealership.servicedeals.repo.model.Deal>> index(){
        final List<com.dealership.servicedeals.repo.model.Deal> deals = dealService.fetchAll();
        return ResponseEntity.ok(deals);
    }

    @GetMapping("/{idDeal}")
    public ResponseEntity<com.dealership.servicedeals.repo.model.Deal> show(@PathVariable Long idDeal){
        try{
            final com.dealership.servicedeals.repo.model.Deal deal = dealService.fetchById(idDeal);
            return ResponseEntity.ok(deal);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.dealership.servicedeals.api.dto.Deal deal){
        final Long carId = deal.getCarId();
        final Long userId = deal.getUserId();
        final String dealDate = deal.getDealDate();
        final String statusDeal = deal.getStatusDeal();

        final Long idDeal = dealService.create(carId, userId, dealDate, statusDeal);
        final String location = String.format("/deals/%d", idDeal);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{idDeal}")
    public ResponseEntity<Void> update(@PathVariable Long idDeal, @RequestBody com.dealership.servicedeals.api.dto.Deal deal){
        final Long carId = deal.getCarId();
        final Long userId = deal.getUserId();
        final String dealDate = deal.getDealDate();
        final String statusDeal = deal.getStatusDeal();
        try{
            dealService.update(idDeal, carId, userId, dealDate, statusDeal);
            return ResponseEntity.noContent().build();
        }catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idDeal}")
    public ResponseEntity<Void> delete(@PathVariable Long idDeal){
        dealService.delete(idDeal);
        return ResponseEntity.noContent().build();
    }
}
