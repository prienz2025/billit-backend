package com.billit.domain.users.repository;

import com.billit.domain.users.entity.BookmarkStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;

public interface BookmarkStationRepository extends JpaRepository<BookmarkStation, Long> {

  @Modifying
  @Query("delete from BookmarkStation bs where bs.id = :bookmarkId")
  void deleteBookmarkById(@NonNull @Param("bookmarkId") Long id);

}