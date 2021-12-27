package com.dealservice.dealservice.model;

import javax.persistence.*;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "deal")
public class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_deal;

    public Long getId_deal() {
        return id_deal;
    }

    public void setId_deal(Long id_deal) {
        this.id_deal = id_deal;
    }


    @Column(name = "car_id")
    private Long carId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }


    @Column(name = "user_id")
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Column(name = "deal_date")
    private String dealDate;

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }


    @Column(name = "status_deal")
    private String statusDeal;

    public String getStatusDeal() {
        return statusDeal;
    }

    public void setStatusDeal(String statusDeal) {
        this.statusDeal = statusDeal;
    }

}
