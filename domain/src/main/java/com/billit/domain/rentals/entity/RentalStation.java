package com.billit.domain.rentals.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rental_stations")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalStation extends BaseEntity {

  private String name;

  private String address;

  @Embedded
  private GeoLocation location;

  private String openTime;

  private String closeTime;

  private String closeDay; // 휴무일 (문자열로 저장)

  private StationStatus status;

  public RentalStation(String name, String address, GeoLocation location, String openTime,
      String closeTime, String closeDay, StationStatus status) {
    this.name = name;
    this.address = address;
    this.location = location;
    this.openTime = openTime;
    this.closeTime = closeTime;
    this.closeDay = closeDay;
    this.status = status;
  }

}