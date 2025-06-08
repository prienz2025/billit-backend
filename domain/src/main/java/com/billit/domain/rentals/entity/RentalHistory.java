package com.billit.domain.rentals.entity;

import com.billit.domain.common.BaseEntity;
import com.billit.domain.users.entity.User;
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
@Table(name = "rental_history")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalHistory extends BaseEntity {

  @Default
  private RentalStatus status = RentalStatus.RENTAL;

  @Column(columnDefinition = "datetime")
  private LocalDateTime startTime;

  @Column(columnDefinition = "datetime")
  private LocalDateTime expectedReturnTime;

  @Column(columnDefinition = "datetime")
  private LocalDateTime returnTime;

  private Integer rentalTimeHour;

  private String token;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_item_id")
  private RentalItem rentalItem;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_station_id")
  private RentalStation rentalStation;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "return_station_id")
  private RentalStation returnStation;

  private RentalHistory(RentalStatus status, LocalDateTime startTime,
      LocalDateTime expectedReturnTime, LocalDateTime returnTime, Integer rentalTimeHour,
      String token, User user, RentalItem rentalItem, RentalStation rentalStation,
      RentalStation returnStation) {
    this.status = status;
    this.startTime = startTime;
    this.expectedReturnTime = expectedReturnTime;
    this.returnTime = returnTime;
    this.rentalTimeHour = rentalTimeHour;
    this.token = token;
    this.user = user;
    this.rentalItem = rentalItem;
    this.rentalStation = rentalStation;
    this.returnStation = returnStation;
  }

  public void changeStatus(RentalStatus status) {
    this.status = status;
  }

  public void extendRentalTime(Integer rentalTime) {
    this.expectedReturnTime = this.expectedReturnTime.plusHours(rentalTime);
    this.rentalTimeHour += rentalTime;
  }

  public void updateOnReturn(RentalStation returnStation, LocalDateTime returnTime) {
    changeStatus(RentalStatus.RETURNED);
    this.returnStation = returnStation;
    this.returnTime = returnTime;
  }

  public boolean isOverdue(LocalDateTime now) {
    return this.expectedReturnTime.isBefore(now);
  }

  public void validateOverdue(LocalDateTime now) {
    if ((this.status.equals(RentalStatus.RENTAL) || this.status.equals(RentalStatus.EXTENSION))
        && isOverdue(now)) {
      changeStatus(RentalStatus.OVERDUE);
    }
  }
}