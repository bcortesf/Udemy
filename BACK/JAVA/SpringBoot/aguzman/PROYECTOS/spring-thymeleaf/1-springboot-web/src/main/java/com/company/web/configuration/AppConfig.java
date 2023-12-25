package com.company.web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.web.ucommons.MyUtility_conInstanciaAppConfig;

@Configuration
public class AppConfig {
	@Bean
	MyUtility_conInstanciaAppConfig BEAN_MyUtility() {
		return new MyUtility_conInstanciaAppConfig();
	}
}
