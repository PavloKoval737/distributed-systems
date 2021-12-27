package com.carservice.carservice.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_car;

    public Long getId_car() {
        return id_car;
    }

    public void setId_car(Long id_car) {
        this.id_car = id_car;
    }


    @Column(name = "new_car")
    private Boolean newCar;

    public Boolean getNewCar() {
        return newCar;
    }

    public void setNewCar(Boolean newCar) {
        this.newCar = newCar;
    }


    @Column(name = "vin_number")
    private String vinNumber;

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    private String marka;
    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }


    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column(name = "year_production")
    private Integer yearProduction;
    public Integer getYearProduction() {
        return yearProduction;
    }

    public void setYearProduction(Integer yearProduction) {
        this.yearProduction = yearProduction;
    }


    @Column(name = "run_car_km")
    private Integer runCarKm;

    public Integer getRunCarKm() {
        return runCarKm;
    }

    public void setRunCarKm(Integer runCarKm) {
        this.runCarKm = runCarKm;
    }


    private String colour;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }


    @Column(name = "type_car")
    private String typeCar;

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Column(name = "price_car_$")
    private Integer priceCar$;

    public Integer getPriceCar$() {
        return priceCar$;
    }

    public void setPriceCar$(Integer priceCar$) {
        this.priceCar$ = priceCar$;
    }

}
