package com.hscastro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AplicationConfig {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
