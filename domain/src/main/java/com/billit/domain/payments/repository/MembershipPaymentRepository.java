package com.billit.domain.payments.repository;

import com.billit.domain.payments.entity.MembershipPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipPaymentRepository extends JpaRepository<MembershipPayment, Long> {

}