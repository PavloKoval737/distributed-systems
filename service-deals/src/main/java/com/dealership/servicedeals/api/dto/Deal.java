package com.dealership.servicedeals.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@NoArgsConstructor
public final class Deal {
    @Column(name = "car_id")
    private Long carId;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "deal_date")
    private String dealDate;
    @Column(name = "status_deal")
    private String statusDeal;
}
