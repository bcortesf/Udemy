package com.company.beans1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigAux2 {

	@Bean
	public Mundo BEAN_World2ID() {
		return new Mundo();
	}

}
