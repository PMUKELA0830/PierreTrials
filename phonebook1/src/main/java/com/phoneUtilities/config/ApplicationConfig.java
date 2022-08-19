package com.phoneUtilities.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.phoneUtilities.repo")
@EntityScan(basePackages="com.phoneUtilities.entity")
public class ApplicationConfig {

}
