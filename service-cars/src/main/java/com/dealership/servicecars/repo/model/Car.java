package com.dealership.servicecars.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public final class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_car")
    private Long idCar;
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

    public Car() {

    }

    public Car(String statusCar, String vinNumber, String marka, String model,
               Integer yearProduction, Integer runCarKm, String colour, String typeCar, Integer priceCar$) {
        this.statusCar = statusCar;
        this.vinNumber = vinNumber;
        this.marka = marka;
        this.model = model;
        this.yearProduction = yearProduction;
        this.runCarKm = runCarKm;
        this.colour = colour;
        this.typeCar = typeCar;
        this.priceCar$ = priceCar$;
    }

    public String getStatusCar() {
        return statusCar;
    }

    public void setStatusCar(String statusCar) {
        this.statusCar = statusCar;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }

    public Integer getRunCarKm() {
        return runCarKm;
    }

    public void setRunCarKm(Integer runCarKm) {
        this.runCarKm = runCarKm;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    public Integer getPriceCar$() {
        return priceCar$;
    }

    public void setPriceCar$(Integer priceCar$) {
        this.priceCar$ = priceCar$;
    }

    public Long getIdCar() {
        return idCar;
    }

    public void setIdCar(Long idCar) {
        this.idCar = idCar;
    }
}
