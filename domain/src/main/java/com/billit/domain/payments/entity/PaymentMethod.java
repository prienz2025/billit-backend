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
public enum PaymentMethod {

  CARD("카드"),
  EASY_PAY("간편결제");

  private static final Map<String, PaymentMethod> MAP = Arrays.stream(values())
      .collect(Collectors.toMap(PaymentMethod::name, Function.identity()));
  private final String description;

  public static PaymentMethod from(String data) {
    return MAP.getOrDefault(data.toUpperCase(), CARD);
  }

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<PaymentMethod> {

    public EnumConverter() {
      super(PaymentMethod.class);
    }

  }

}
