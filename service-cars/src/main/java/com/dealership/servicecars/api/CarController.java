package com.dealership.servicecars.api;

import com.dealership.servicecars.service.CarService;
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
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    @GetMapping
    public ResponseEntity<List<com.dealership.servicecars.repo.model.Car>> index(){
        final List<com.dealership.servicecars.repo.model.Car> cars = carService.fetchAll();
        return ResponseEntity.ok(cars);
    }

    @GetMapping("/{idCar}")
    public ResponseEntity<com.dealership.servicecars.repo.model.Car> show(@PathVariable Long idCar){
        try{
            final com.dealership.servicecars.repo.model.Car car = carService.fetchById(idCar);
            return ResponseEntity.ok(car);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody com.dealership.servicecars.api.dto.Car car){
        final String statusCar = car.getStatusCar();
        final String vinNumber = car.getVinNumber();
        final String marka = car.getMarka();
        final String model = car.getModel();
        final Integer yearProduction = car.getYearProduction();
        final Integer runCarKm = car.getRunCarKm();
        final String colour = car.getColour();
        final String typeCar = car.getTypeCar();
        final Integer priceCar$ = car.getPriceCar$();

        final long idCar = carService.create(statusCar, vinNumber, marka, model, yearProduction, runCarKm, colour, typeCar,
                priceCar$);
        final String location = String.format("/cars/%d", idCar);

        return ResponseEntity.created(URI.create(location)).build();
    }

    @PatchMapping("/{idCar}")
    public ResponseEntity<Void> update(@PathVariable Long idCar, @RequestBody com.dealership.servicecars.api.dto.Car car){
        final String statusCar = car.getStatusCar();
        final String vinNumber = car.getVinNumber();
        final String marka = car.getMarka();
        final String model = car.getModel();
        final Integer yearProduction = car.getYearProduction();
        final Integer runCarKm = car.getRunCarKm();
        final String colour = car.getColour();
        final String typeCar = car.getTypeCar();
        final Integer priceCar$ = car.getPriceCar$();
        try{
            carService.update(idCar, statusCar, vinNumber, marka, model, yearProduction, runCarKm, colour, typeCar,
                    priceCar$);
            return ResponseEntity.noContent().build();
        }catch(IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idCar}")
    public ResponseEntity<Void> delete(@PathVariable Long idCar){
        carService.delete(idCar);
        return ResponseEntity.noContent().build();
    }
}
