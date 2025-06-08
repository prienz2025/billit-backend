package com.billit.domain.payments.repository;

import com.billit.domain.payments.entity.RentalPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalPaymentRepository extends JpaRepository<RentalPayment, Long> {

}