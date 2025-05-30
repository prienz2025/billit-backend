package com.billit.domain.rentals.repository;

import com.billit.domain.rentals.entity.RentalItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalItemRepository extends JpaRepository<RentalItem, Long> {

}