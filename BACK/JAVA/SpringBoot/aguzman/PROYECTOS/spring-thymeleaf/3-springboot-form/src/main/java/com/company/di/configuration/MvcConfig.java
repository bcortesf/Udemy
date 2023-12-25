package com.company.di.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	/**
	 * /3-springboot-form/src/main/java/com/company/di/interceptors/TiempoTranscurridoInterceptor.java
	 * public class TiempoTranscurridoInterceptor implements HandlerInterceptor {...}
	 */
	//@Autowired private TiempoTranscurridoInterceptor tiempoTranscurridoInterceptor;  //->CLASE-CONCRETA
	@Autowired @Qualifier(value = "TTiempoTranscurridoInterceptor") 
		private HandlerInterceptor tiempoTranscurridoInterceptor;                                         //->INTERFAZ-GENERICA
	

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		/*
		 * /3-springboot-form/src/main/java/com/company/di/controller/FormularioValidationController2.java
		 * @GetMapping(path = {"/form2"})
		 * @	PostMapping(path = "/form_entidadUsuario_valida1")
		 */
		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form2/**", "/form_entidadUsuario_valida1");
		
		//-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
																							/*						OPCIONES				*/

		/*Interceptor se aplica a:  TODAS  las rutas y todos los controladores de forma global; Todos los metodos handlers*/
//		registry.addInterceptor(tiempoTranscurridoInterceptor);

		/*Interceptor se aplica a: UNICA ruta, controlador, metodo-handler*/
//		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form2/**"); // cualquier ruta que venga despues de  "form"

		/*Interceptor se aplica a: UNICA ruta, controlador, metodo-handler*/
//		registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form2/**", "/admin/usuarios"); // cualquier ruta despues de"form",  y una tuta especifica "/admin/usuarios"
	}
	
}

