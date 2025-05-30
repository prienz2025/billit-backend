package com.billit.domain.rentals.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rental_items")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalItem extends BaseEntity {

  private RentalItemStatus status = RentalItemStatus.AVAILABLE;

  private String token;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_item_type_id")
  private RentalItemType rentalItemType;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "current_station_id")
  private RentalStation currentStation;

  private RentalItem(RentalItemStatus status, String token, RentalItemType rentalItemType,
      RentalStation currentStation) {
    this.status = status;
    this.token = token;
    this.rentalItemType = rentalItemType;
    this.currentStation = currentStation;
  }

}