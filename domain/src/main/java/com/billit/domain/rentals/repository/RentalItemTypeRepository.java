package com.billit.domain.rentals.repository;

import com.billit.domain.rentals.entity.RentalItemType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalItemTypeRepository extends JpaRepository<RentalItemType, Long> {

}