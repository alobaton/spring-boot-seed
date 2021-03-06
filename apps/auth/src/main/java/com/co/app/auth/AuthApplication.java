/**
 * 
 */
package com.co.app.auth;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.ldap.LdapAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

import com.co.app.auth.configuration.RibbonConfiguration;
import com.co.app.commons.utils.DateUtil;

/**
 * @author alobaton
 *
 */
@EnableDiscoveryClient
@RibbonClients(defaultConfiguration = RibbonConfiguration.class)
@SpringBootApplication(exclude = { LdapAutoConfiguration.class })
public class AuthApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AuthApplication.class);
	}

	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone(DateUtil.ZONE_ID));
	}
}
