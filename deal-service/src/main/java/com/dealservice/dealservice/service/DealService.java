package com.dealservice.dealservice.service;

import com.dealservice.dealservice.exception.DealNotFoundException;
import com.dealservice.dealservice.model.Deal;
import com.dealservice.dealservice.repo.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class DealService
{
    private final DealRepository dealRepository;

    public DealService(DealRepository dealRepository)
    {
        this.dealRepository = dealRepository;
    }

    public List<Deal> getdeals()
    {
        return dealRepository.findAll();
    }

    public Deal saveDeal(Deal newDeal)
    {
        return dealRepository.save(newDeal);
    }

    public Deal getDealById(Long id_deal)
    {
        Optional<Deal> deal = dealRepository.findById(id_deal);
        if (deal.isPresent())
        {
            log.info("deal: {}", deal.get());
            return deal.get();
        }
        throw new DealNotFoundException();
    }

    public Deal updateDealById(Long id_deal, Deal updatedDeal)
    {
        Optional<Deal> deal = dealRepository.findById(id_deal);
        if (deal.isPresent()) {
            Deal oldDeal = deal.get();
            log.info("deal: {}", oldDeal);
            updateDeal(oldDeal, updatedDeal);
            return dealRepository.save(oldDeal);
        }
        throw new DealNotFoundException();
    }

    private void updateDeal(Deal oldDeal, Deal updatedDeal)
    {
        oldDeal.setCarId(updatedDeal.getCarId());
        oldDeal.setUserId(updatedDeal.getUserId());
        oldDeal.setDealDate(updatedDeal.getDealDate());
        oldDeal.setStatusDeal(updatedDeal.getStatusDeal());
    }

    public void updateDealPatch(long id_deal, String dealDate, String statusDeal) throws IllegalArgumentException{
        final Optional<Deal> someDeal = dealRepository.findById(id_deal);
        if (someDeal.isEmpty()) throw new IllegalArgumentException("Deal not found");

        final Deal deal = someDeal.get();
        if (dealDate != null && !dealDate.isBlank()) deal.setDealDate(dealDate);
        if (statusDeal != null && !statusDeal.isBlank()) deal.setStatusDeal(statusDeal);
        dealRepository.save(deal);
    }

    public String deleteDealById(Long id_deal)
    {
        dealRepository.deleteById(id_deal);
        return "Deal was successfully deleted!";
    }
}