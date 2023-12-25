package com.company.interceptorHorario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.company.interceptorHorario.interceptors.HorarioInterceptor;

@Configuration
public class MvcConfig implements WebMvcConfigurer {
	
	@Autowired @Qualifier(value = "horarioInterceptor")
		private HorarioInterceptor horarioInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//                                          @GetMapping(path = {"/horarioCerrado"})
		registry.addInterceptor(horarioInterceptor).excludePathPatterns("/horarioCerrado");
	}

}
