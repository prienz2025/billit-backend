package com.billit.domain.rentals.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RentalItemStatus {
  AVAILABLE("대여 가능"),
  RENTED("대여 중"),
  CRASHED("고장"),
  LOST("분실");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<RentalItemStatus> {

    public EnumConverter() {
      super(RentalItemStatus.class);
    }

  }

}