package com.billit.api;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.billit.domain.entity")
@EnableJpaRepositories(basePackages = "com.billit.domain.repository")
public class DBConfig {
}
