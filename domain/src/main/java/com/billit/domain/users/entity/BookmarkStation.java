package com.billit.domain.users.entity;

import com.billit.domain.common.BaseEntity;
import com.billit.domain.rentals.entity.RentalStation;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmark_stations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BookmarkStation extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private User user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "rental_station_id")
  private RentalStation rentalStation;

  public BookmarkStation(User user, RentalStation rentalStation) {
    this.user = user;
    this.rentalStation = rentalStation;
  }

}