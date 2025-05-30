package com.billit.domain.rentals.repository;

import com.billit.domain.rentals.entity.RentalHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalHistoryRepository extends JpaRepository<RentalHistory, Long> {

}