package com.billit.domain.common;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreatedDate
  @Column(updatable = false, nullable = false, columnDefinition = "datetime default current_timestamp")
  private LocalDateTime createdAt;

  @LastModifiedDate
  @Column(nullable = false, columnDefinition = "datetime default current_timestamp on update current_timestamp")
  private LocalDateTime updatedAt;

  @Column(columnDefinition = "datetime")
  private LocalDateTime deletedAt;

  public void updateDeletedAt() {
    this.deletedAt = LocalDateTime.now();
  }

  public boolean isDeleted() {
    return Objects.nonNull(this.deletedAt);
  }

}