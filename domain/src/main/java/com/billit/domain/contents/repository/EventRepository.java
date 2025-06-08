package com.billit.domain.contents.repository;

import com.billit.domain.contents.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}