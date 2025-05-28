package com.billit.domain.users.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

  ADMIN("ROLE_ADMIN"),
  MANAGER("ROLE_MANAGER"),
  USER("ROLE_USER");

  private final String key;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<Role> {

    public EnumConverter() {
      super(Role.class);
    }

  }
}
