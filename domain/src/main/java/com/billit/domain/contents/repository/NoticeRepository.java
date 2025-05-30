package com.billit.domain.contents.repository;

import com.billit.domain.contents.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoticeRepository extends JpaRepository<Notice, Long> {

}