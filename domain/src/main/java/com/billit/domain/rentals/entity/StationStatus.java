package com.billit.domain.rentals.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StationStatus {

  OPEN("운영 중"),
  CLOSED("운영 종료");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<StationStatus> {

    public EnumConverter() {
      super(StationStatus.class);
    }

  }

}