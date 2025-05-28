package com.billit.domain.users.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProviderType {

  GOOGLE("구글"),
  KAKAO("카카오"),
  LOCAL("로컬");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<ProviderType> {

    public EnumConverter() {
      super(ProviderType.class);
    }

  }
}