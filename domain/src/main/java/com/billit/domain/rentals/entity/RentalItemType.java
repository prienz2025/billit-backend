package com.billit.domain.rentals.entity;

import com.billit.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "rental_item_types")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RentalItemType extends BaseEntity {

  private RentalItemCategory category;

  private String name;

  private String image;

  private String description;

  private Integer price;

  @Builder
  private RentalItemType(RentalItemCategory category, String name, String image, String description,
      Integer price) {
    this.category = category;
    this.name = name;
    this.image = image;
    this.description = description;
    this.price = price;
  }

}