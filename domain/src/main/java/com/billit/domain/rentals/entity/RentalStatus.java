package com.billit.domain.rentals.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RentalStatus {

  RENTAL("대여 중"),
  EXTENSION("연장"),
  OVERDUE("연체"),
  OVERDUE_PAID("연체 납부"),
  RETURNED("반납");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<RentalStatus> {

    public EnumConverter() {
      super(RentalStatus.class);
    }
  }

}