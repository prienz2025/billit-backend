package com.billit.domain.payments.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RentalPaymentType {

  RENT("대여 결제"),
  OVERDUE("연체 결제"),
  EXTENSION("연장 결제");

  private static final Map<String, RentalPaymentType> MAP = Arrays.stream(values())
      .collect(Collectors.toMap(RentalPaymentType::name, Function.identity()));

  private final String description;

  public static RentalPaymentType from(String data) {
    return MAP.getOrDefault(data.toUpperCase(), RENT);
  }

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<RentalPaymentType> {

    public EnumConverter() {
      super(RentalPaymentType.class);
    }

  }

}