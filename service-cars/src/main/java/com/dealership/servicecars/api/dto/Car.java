package com.dealership.servicecars.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public final class Car {
    @Column(name = "status_car")
    private String statusCar;
    @Column(name = "vin_number")
    private String vinNumber;
    private String marka;
    private String model;
    @Column(name = "year_production")
    private Integer yearProduction;
    @Column(name = "run_car_km")
    private Integer runCarKm;
    private String colour;
    @Column(name = "type_car")
    private String typeCar;
    @Column(name = "price_car_$")
    private Integer priceCar$;
}
