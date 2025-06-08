package com.billit.domain.rentals.repository;

import com.billit.domain.rentals.entity.RentalStationItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalStationItemRepository extends JpaRepository<RentalStationItem, Long> {

}