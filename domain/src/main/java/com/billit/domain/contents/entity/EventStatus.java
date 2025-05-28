package com.billit.domain.contents.entity;

import com.billit.domain.converter.AbstractEnumConverter;
import jakarta.persistence.Converter;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {

  UP_COMING("예정"),
  ON_GOING("진행중"),
  END("종료");

  private final String description;

  @Converter(autoApply = true)
  static class EnumConverter extends AbstractEnumConverter<EventStatus> {

    public EnumConverter() {
      super(EventStatus.class);
    }

  }

}