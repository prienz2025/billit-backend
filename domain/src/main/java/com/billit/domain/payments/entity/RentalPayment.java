package com.billit.domain.payments.entity;

import com.billit.domain.common.BaseEntity;
import com.billit.domain.rentals.entity.RentalHistory;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rental_payments")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalPayment extends BaseEntity {

  private RentalPaymentType paymentType;

  @Default
  private PaymentStatus status = PaymentStatus.APPROVED;

  private PaymentMethod paymentMethod;

  @Column(columnDefinition = "datetime")
  private LocalDateTime paymentDate;

  private String orderName;

  private Integer totalAmount;

  private String orderId;

  private String paymentKey;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_history_id")
  private RentalHistory rentalHistory;

  private RentalPayment(RentalPaymentType paymentType, PaymentStatus status,
      PaymentMethod paymentMethod, LocalDateTime paymentDate, String orderName, Integer totalAmount,
      String orderId, String paymentKey, RentalHistory rentalHistory) {
    this.paymentType = paymentType;
    this.status = status;
    this.paymentMethod = paymentMethod;
    this.paymentDate = paymentDate;
    this.orderName = orderName;
    this.totalAmount = totalAmount;
    this.orderId = orderId;
    this.paymentKey = paymentKey;
    this.rentalHistory = rentalHistory;
  }
  
}