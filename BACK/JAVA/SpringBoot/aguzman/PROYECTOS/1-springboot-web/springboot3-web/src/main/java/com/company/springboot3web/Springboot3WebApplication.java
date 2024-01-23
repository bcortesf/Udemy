package com.company.springboot3web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.context.annotation.PropertySources;

//---------------------------------------------------------------------
			/*MIGRACION CLASE CONFIGURACION <ValuesConfig.class> */

/** APUNTA A LOS DOS PATH
 * classpath = src/main/java
 * classpath = src/main/resources
 */

/*FORMA-1: individual */
// @PropertySource(value = "classpath:values-custom.properties", encoding = "UTF-8")

/*FORMA-2: multiples */
// @PropertySources(value = {
// 	@PropertySource(value = "classpath:values-custom.properties", encoding = "UTF-8")
// 	,@PropertySource(value = "classpath:/propertyValue/values-custom2.properties", encoding = "UTF-8")
// })

//---------------------------------------------------------------------
@SpringBootApplication
public class Springboot3WebApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3WebApplication.class, args);
	}

}

//@PropertySource(value = "classpath:/com/myco/app.properties")