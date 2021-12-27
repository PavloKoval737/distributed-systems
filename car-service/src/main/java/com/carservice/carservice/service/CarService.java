package com.carservice.carservice.service;

import com.carservice.carservice.exception.CarNotFoundException;
import com.carservice.carservice.model.Car;
import com.carservice.carservice.repo.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public List<Car> getcars()
    {
        return carRepository.findAll();
    }

    public Car saveCar(Car newCar) {
        return carRepository.save(newCar);
    }

    public Car getCarById(Long id_car) {
        Optional<Car> car = carRepository.findById(id_car);
        if (car.isPresent()) {
            log.info("car: {}", car.get());
            return car.get();
        }
        throw new CarNotFoundException();
    }

    public Car updateCarById(Long id_car, Car updatedCar) {
        Optional<Car> car = carRepository.findById(id_car);
        if (car.isPresent()) {
            Car oldCar = car.get();
            log.info("status: {}", oldCar);
            updateCar(oldCar, updatedCar);
            return carRepository.save(oldCar);
        }
        throw new CarNotFoundException();
    }

    private void updateCar(Car oldCar, Car updatedCar) {
        oldCar.setNewCar(updatedCar.getNewCar());
        oldCar.setVinNumber(updatedCar.getVinNumber());
        oldCar.setMarka(updatedCar.getMarka());
        oldCar.setModel(updatedCar.getModel());
        oldCar.setYearProduction(updatedCar.getYearProduction());
        oldCar.setRunCarKm(updatedCar.getRunCarKm());
        oldCar.setColour(updatedCar.getColour());
        oldCar.setTypeCar(updatedCar.getTypeCar());
        oldCar.setPriceCar$(updatedCar.getPriceCar$());

    }

    public void updateCarPatch(long id_car, String marka, String model, String colour, String typeCar) throws IllegalArgumentException{
        final Optional<Car> someCar = carRepository.findById(id_car);
        if (someCar.isEmpty()) throw new IllegalArgumentException("Car not found");

        final Car car = someCar.get();
        if (marka != null && !marka.isBlank()) car.setMarka(marka);
        if (model != null && !model.isBlank()) car.setModel(model);
        if (typeCar != null && !typeCar.isBlank()) car.setTypeCar(typeCar);
        if (colour != null && !colour.isBlank()) car.setColour(colour);
        carRepository.save(car);
    }

    public String deleteCarById(Long id_car) {
        carRepository.deleteById(id_car);
        return "Car was successfully deleted!";
    }

}
