package com.dealership.servicedeals.repo;

import com.dealership.servicedeals.repo.model.Deal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepo extends JpaRepository<Deal, Long> {
}
