package com.billit.domain.rentals.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rental_station_items")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalStationItem extends BaseEntity {

  private Integer stock;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_station_id")
  private RentalStation rentalStation;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_item_type_id")
  private RentalItemType rentalItemType;

  public RentalStationItem(Integer stock, RentalStation rentalStation,
      RentalItemType rentalItemType) {
    this.stock = stock;
    this.rentalStation = rentalStation;
    this.rentalItemType = rentalItemType;
  }

  public void decreaseStock() {
    if (this.stock == 0) {
      throw new RuntimeException("Stock exceeded");
    }
    this.stock--;
  }

  public void increaseStock() {
    this.stock++;
  }

}
