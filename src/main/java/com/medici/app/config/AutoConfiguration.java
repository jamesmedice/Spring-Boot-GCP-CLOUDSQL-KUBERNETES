package com.medici.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "com.medici.app.entity")
@EnableJpaRepositories(basePackages = "com.medici.app.repository")
@EnableAutoConfiguration
public class AutoConfiguration {

}
