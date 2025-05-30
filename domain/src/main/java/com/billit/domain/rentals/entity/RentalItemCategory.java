package com.billit.domain.rentals.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RentalItemCategory {

  CHARGER("충전기"),
  CABLE("케이블"),
  HUB("허브"),
  POWER_BANK("보조 배터리"),
  MOUSE("마우스"),
  KEYBOARD("키보드"),
  LAPTOP_STAND("노트북 스탠드"),
  ETC("기타");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<RentalItemCategory> {

    public EnumConverter() {
      super(RentalItemCategory.class);
    }

  }

}