package com.dealership.servicedeals.service;

import com.dealership.servicedeals.repo.DealRepo;
import com.dealership.servicedeals.repo.model.Deal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public final class DealService {

    private final DealRepo dealRepo;

    public List<Deal> fetchAll(){
        return dealRepo.findAll();
    }

    public Deal fetchById(Long idDeal) throws IllegalArgumentException{
        final Optional<Deal> maybeDeal = dealRepo.findById(idDeal);

        if (maybeDeal.isEmpty()) throw new IllegalArgumentException("Deal not found");
        else return maybeDeal.get();
    }

    public long create(long carId, long userId, String dealDate, String statusDeal)
    {
        final Deal deal = new Deal(carId, userId, dealDate, statusDeal);
        final Deal savedDeal = dealRepo.save(deal);

        return savedDeal.getIdDeal();
    }

    public void update(Long idDeal, Long carId, Long userId, String dealDate, String statusDeal) throws IllegalArgumentException
    {
        final Optional<Deal> maybeDeal = dealRepo.findById(idDeal);
        if (maybeDeal.isEmpty()) throw new IllegalArgumentException("Deal not found");

        final Deal deal = maybeDeal.get();

        if(carId != null && carId >= 0) deal.setCarId(carId);
        if(userId != null && userId >= 0) deal.setUserId(userId);
        if(dealDate != null && !dealDate.isBlank()) deal.setDealDate(dealDate);
        if(statusDeal != null && !statusDeal.isBlank()) deal.setStatusDeal(statusDeal);

        dealRepo.save(deal);

    }

    public void delete(Long idDeal)
    {
        dealRepo.deleteById(idDeal);
    }

}
