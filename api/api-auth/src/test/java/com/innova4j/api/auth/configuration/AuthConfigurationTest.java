/**
 * 
 */
package com.innova4j.api.auth.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author alobaton
 *
 */
@PropertySource("classpath:application.properties")
@EnableJpaRepositories(basePackages = { "com.innova4j.api.auth.dao" })
@EntityScan(basePackages = { "com.innova4j.api.auth.domain" })
@EnableJpaAuditing
@EnableTransactionManagement
public class AuthConfigurationTest {
}
