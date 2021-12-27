package com.carservice.carservice.api;

import com.carservice.carservice.model.Car;
import com.carservice.carservice.service.CarService;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;


@RestController
public class CarController
{
    private final CarService carService;

    private final RestTemplate restTemplate;

    @RequestMapping(value="/")
    public String car() throws JsonParseException
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("message", "This is car service");
        return jsonObject.toString();
    }

    @Autowired
    public CarController(CarService carService, RestTemplate restTemplate)
    {
        this.carService = carService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(value = "/car")
    public ResponseEntity<List<Car>> getcars() {
        return ResponseEntity.ok(carService.getcars());
    }

    @PostMapping(value = "/car")
    public ResponseEntity<Car> postCars(@Valid @RequestBody Car newCar) {
        return ResponseEntity.ok(carService.saveCar(newCar));
    }

    @GetMapping(value = "/car/{id_car}")
    public ResponseEntity<Car> getCar(@PathVariable Long id_car) {
        return ResponseEntity.ok(carService.getCarById(id_car));
    }

    @PutMapping(value = "/car/{id_car}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id_car, @Valid @RequestBody Car updatedCar) {
        return ResponseEntity.ok(carService.updateCarById(id_car, updatedCar));
    }

    @PatchMapping("/car/{id_car}")
    public ResponseEntity<Void> updateCarPatch(@PathVariable long id_car, @RequestBody Car car) {
        final String marka = car.getMarka();
        final String model = car.getModel();
        final String colour = car.getColour();
        final String typeCar = car.getTypeCar();

        try {
            carService.updateCarPatch(id_car, marka, model, colour, typeCar);
            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/car/{id_car}")
    public ResponseEntity<String> deleteCar(@PathVariable Long id_car) {
        return ResponseEntity.ok(carService.deleteCarById(id_car));
    }

}
