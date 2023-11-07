package com.company.beans1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	/*
	 * /SpringFramework/src/main/resources/com/company/xml/bean.xml
	 * LA DEFINICION DE ESTE BEAN
	   <bean id="BEAN_MundoID" class="com.company.beans.Mundo">
			<property 
				name="saludo" value="Hola Bryan!!">
			</property>
		</bean>
	 * 
	 * ES EQUIVALENTE A TENER:
	 * 	nota: "BEAN_MundoID" ES UN APODO QUE DEBO DARLE AL METODO, Y SPRING LO MAPEA AUTOMATICAMENTE POR MI
	 */
	@Bean
	public Mundo BEAN_MundoID() {
		return new Mundo();
	}

}
