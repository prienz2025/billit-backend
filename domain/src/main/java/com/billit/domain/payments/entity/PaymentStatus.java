package com.billit.domain.payments.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum PaymentStatus {

  APPROVED("승인"),
  CANCELLED("취소");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<PaymentStatus> {

    public EnumConverter() {
      super(PaymentStatus.class);
    }

  }

}