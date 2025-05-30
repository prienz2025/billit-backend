package com.billit.domain.payments.entity;

import com.billit.domain.common.BaseEntity;
import com.billit.domain.users.entity.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "membership_payments")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MembershipPayment extends BaseEntity {

  private LocalDateTime paymentDate;

  private LocalDateTime startDate;

  private LocalDateTime expirationDate;

  private Integer extensionCount;

  private Integer totalAmount;

  private String orderId;

  private String paymentKey;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

}