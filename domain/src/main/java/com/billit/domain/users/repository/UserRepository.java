package com.billit.domain.users.repository;

import com.billit.domain.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  Boolean existsByEmail(String email);

  Boolean existsByNickname(String nickname);

}