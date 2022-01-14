package com.dealership.servicecars.service;

import com.dealership.servicecars.repo.CarRepo;
import com.dealership.servicecars.repo.model.Car;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class CarService {

    private final CarRepo carRepo;

    public List<Car> fetchAll(){
        return carRepo.findAll();
    }

    public Car fetchById(Long idCar) throws IllegalArgumentException{
        final Optional<Car> maybeCar = carRepo.findById(idCar);

        if (maybeCar.isEmpty()) throw new IllegalArgumentException("Car not found");
        else return maybeCar.get();
    }

    public long create(String statusCar, String vinNumber, String marka, String model,
                       Integer yearProduction, Integer runCarKm, String colour, String typeCar, Integer priceCar$)
    {
        final Car car = new Car(statusCar, vinNumber, marka, model, yearProduction, runCarKm, colour, typeCar,
                priceCar$);
        final Car savedCar = carRepo.save(car);

        return savedCar.getIdCar();
    }

    public void update(Long idCar, String statusCar, String vinNumber, String marka, String model, Integer yearProduction,
                       Integer runCarKm, String colour, String typeCar, Integer priceCar$) throws IllegalArgumentException
    {
        final Optional<Car> maybeCar = carRepo.findById(idCar);
        if (maybeCar.isEmpty()) throw new IllegalArgumentException("Car not found");

        final Car car = maybeCar.get();
        if(statusCar != null && !statusCar.isBlank()) car.setStatusCar(statusCar);
        if(vinNumber != null && !vinNumber.isBlank()) car.setVinNumber(vinNumber);
        if(marka != null && !marka.isBlank()) car.setMarka(marka);
        if(model != null && !model.isBlank()) car.setModel(model);
        if(yearProduction != null && yearProduction >= 0) car.setYearProduction(yearProduction);
        if(runCarKm != null && runCarKm >= 0) car.setRunCarKm(runCarKm);
        if(colour != null && !colour.isBlank()) car.setColour(colour);
        if(typeCar != null && !typeCar.isBlank()) car.setTypeCar(typeCar);
        if(priceCar$ != null && priceCar$ >= 0) car.setPriceCar$(priceCar$);
        carRepo.save(car);

    }

    public void delete(Long idCar)
    {
        carRepo.deleteById(idCar);
    }

}
