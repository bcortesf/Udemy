package com.empresabcf.sb.di.app.models.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/*
 * SERVICE: 
 * - Interactura con los DAO, que acceden a los datos
 * - Un service se puede comunicar mediante API REST, utilizando un 
     cliente HTPP como "Red template" para opbtener los datos desde otro servicio;
     Por ejemplo una arquitectura de microservicios con JSON-API-REST
 * - Acceso a datos conlos datos ó con repository y con metodos que realizan consultas. 
 */



//@Component(value = "servicioDI2")
//@Service @Qualifier(value = "servicioDI2")

@Service(value = "servicioDI2")
public class Servicio_ConInyeccionDependencia2 implements IServicio {
	
	public Servicio_ConInyeccionDependencia2() {}

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
		return "Inyeccion por 'Atributo' #2";
	}

	@Override
	public String getInyeccionDependenciaPorSetter() {
		return "Inyeccion por 'MetodoSet' #2";
	}

	@Override
	public String getInyeccionDependenciaPorConstructor() {
		return "Inyeccion por 'Constructor' #2";
	}

}
