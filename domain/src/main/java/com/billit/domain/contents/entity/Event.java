package com.billit.domain.contents.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Event extends BaseEntity {

  private String title;

  private String bannerImage;

  private String contentImage;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private EventStatus status;

}