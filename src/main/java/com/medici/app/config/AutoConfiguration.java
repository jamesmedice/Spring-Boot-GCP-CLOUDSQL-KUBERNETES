package com.medici.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.medici.app.entity.Invoice;
import com.medici.app.repository.InvoiceRepository;

@Configuration
@EntityScan(basePackageClasses = { Invoice.class })
@EnableJpaRepositories(basePackageClasses = { InvoiceRepository.class })
@EnableAutoConfiguration
public class AutoConfiguration {

}
