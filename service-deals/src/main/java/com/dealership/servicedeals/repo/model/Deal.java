package com.dealership.servicedeals.repo.model;

import javax.persistence.*;

@Entity
@Table(name = "deal")
public final class Deal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_deal")
    private Long idDeal;
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "deal_date")
    private String dealDate;
    @Column(name = "status_deal")
    private String statusDeal;

    public Deal() {

    }

    public Deal(Long carId, Long userId, String dealDate, String statusDeal) {
        this.carId = carId;
        this.userId = userId;
        this.dealDate = dealDate;
        this.statusDeal = statusDeal;
    }

    public Long getIdDeal() {
        return idDeal;
    }

    public void setIdDeal(Long idDeal) {
        this.idDeal = idDeal;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getDealDate() {
        return dealDate;
    }

    public void setDealDate(String dealDate) {
        this.dealDate = dealDate;
    }

    public String getStatusDeal() {
        return statusDeal;
    }

    public void setStatusDeal(String statusDeal) {
        this.statusDeal = statusDeal;
    }
}
