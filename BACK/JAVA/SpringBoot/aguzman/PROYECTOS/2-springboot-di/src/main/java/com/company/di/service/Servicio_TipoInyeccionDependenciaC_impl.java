package com.company.di.service;

import org.springframework.stereotype.Component;

/**
 * SE REGISTRA DE FORMA MANUAL ESTE (@Componet ó @Service)  en:
 * /2-springboot-di/src/main/java/com/company/di/AppConfig.java
 */

//@Component(value = "servicioDI_C")
public class Servicio_TipoInyeccionDependenciaC_impl implements IServicio {

	@Override
	public String getInyeccionDependencia_porAtributo() {
		StringBuilder rta = new StringBuilder();;
		rta.append("<div>");
//			rta.append("<span class='me-5'> Inyeccion por:   [C]. '#Atributo', </span>");
			rta.append("<div> Inyeccion por:   [C]. '#Atributo', </div>");
			rta.append("REGISTRANDO-COMPONENTE-MANUALMENTE:  <span class=\"text-primary fw-bold\">@Configuration @Bean</span>");
			rta.append("<code> '/2-springboot-di/src/main/java/com/company/di/AppConfig.java' </code>");
//			rta.append("<span class=\"fw-bold\"> '/2-springboot-di/src/main/java/com/company/di/AppConfig.java' </span>");
		rta.append("</div>");
		return rta.toString();
	}

	@Override
	public String getInyeccionDependencia_porSetter() {
		return "Inyeccion por:   [C]. '#MetodoSet'";
	}

	@Override
	public String getInyeccionDependencia_porConstructor() {
		return "Inyeccion por:   [C]. '#Constructor'";
	}

}
