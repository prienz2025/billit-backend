package com.billit.domain.rentals.repository;

import com.billit.domain.rentals.entity.RentalStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalStationRepository extends JpaRepository<RentalStation, Long> {

}