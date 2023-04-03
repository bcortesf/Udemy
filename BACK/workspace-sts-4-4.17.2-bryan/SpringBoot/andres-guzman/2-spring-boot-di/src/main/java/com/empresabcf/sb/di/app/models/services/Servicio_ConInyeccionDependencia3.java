package com.empresabcf.sb.di.app.models.services;

/*
 * SERVICE: 
 * - Interactura con los DAO, que acceden a los datos
 * - Un service se puede comunicar mediante API REST, utilizando un 
     cliente HTPP como "Red template" para opbtener los datos desde otro servicio;
     Por ejemplo una arquitectura de microservicios con JSON-API-REST
 * - Acceso a datos conlos datos ó con repository y con metodos que realizan consultas. 
 */


/**
 * SE REGISTRA DE FORMA MANUAL ESTE (@Componet ó @Service)  en:
 * /2-spring-boot-di/src/main/java/com/empresabcf/sb/di/app/AppConfig.java
 */
public class Servicio_ConInyeccionDependencia3 implements IServicio {
	
	public Servicio_ConInyeccionDependencia3() {}

	@Override
	public String operacion() {
		StringBuilder rta = new StringBuilder();;
		rta.append("Ejecutando algún proceso importante__conInyeccion#2 + @Qualifier");
		rta.append("<ul>");
			rta.append("<li style='color: red'>@Qualifier(Para DOS o mas implementaciones concretas de una interfaz</li>");
			rta.append("<li class=\"fw-bold\">Si es una interfaz con 'UNA SOLA IMPLEMENTACION CONCRETA, no se necesita @Qualifier'</li>");
		rta.append("</ul>");
		rta.append("");
		return rta.toString();	
	}


	@Override
	public String getInyeccionDependenciaPorAtributo() {
		StringBuilder rta = new StringBuilder();;
		rta.append("<div>");
			rta.append("<span class='me-5'>Inyeccion por 'Atributo' #3,</span>");
			rta.append("REGISTRANDO-COMPONENTE-MANUALMENTE:  <span class=\"text-primary fw-bold\">@Configuration @Bean</span>");
			rta.append("<span class=\"fw-bold\"> '/2-spring-boot-di/src/main/java/com/empresabcf/sb/di/app/AppConfig.java' </span>");
		rta.append("</div>");
		return rta.toString();
	}

	@Override
	public String getInyeccionDependenciaPorSetter() {
		return "Inyeccion por 'MetodoSet' #3";
	}

	@Override
	public String getInyeccionDependenciaPorConstructor() {
		return "Inyeccion por 'Constructor' #3";
	}

}
