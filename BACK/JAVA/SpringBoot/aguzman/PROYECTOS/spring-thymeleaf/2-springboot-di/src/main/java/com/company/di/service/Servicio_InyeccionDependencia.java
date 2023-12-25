package com.company.di.service;

import org.springframework.stereotype.Component;

/*		FORMA-1		*/
//@Component(value = "servicioDI_1")
/*		FORMA-2		*/
//@Service(value = "servicioDI_1")
/*		FORMA-3		*/
//@Service @Qualifier(value = "servicioDI_1")

@Component
public class Servicio_InyeccionDependencia {

	public String[] OperacionLista() {
		String[] listaUsuario = {
				"Obteniendo usuario[Bryan]    :",
				getClass().getName(),
				notasSobreInyeccionDependencia()
		};
		return listaUsuario;
	}
	
	public String notasSobreInyeccionDependencia() {
		StringBuilder rta = new StringBuilder();;
		rta.append("Notas Inyeccion de Dependencia #A  (@Qualifier)");
		rta.append("<ul>");
			rta.append("<li style='color: red'>@Qualifier(Para DOS o mas implementaciones concretas de una interfaz</li>");
			rta.append("<li class=\"fw-bold\">Si es una interfaz con 'UNA SOLA IMPLEMENTACION CONCRETA, no se necesita @Qualifier'</li>");
		rta.append("</ul>");
		rta.append("");
		return rta.toString();
	}

}
