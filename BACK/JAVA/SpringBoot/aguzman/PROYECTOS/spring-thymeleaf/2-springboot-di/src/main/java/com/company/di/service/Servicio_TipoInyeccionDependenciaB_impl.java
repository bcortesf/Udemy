package com.company.di.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/*		FORMA-1		*/
//@Component(value = "servicioDI_B")
/*		FORMA-2		*/
//@Service(value = "servicioDI_B")
/*		FORMA-3		*/
//@Service @Qualifier(value = "servicioDI_B")

@Service @Qualifier(value = "servicioDI_B")
public class Servicio_TipoInyeccionDependenciaB_impl implements IServicio {

	@Override
	public String getInyeccionDependencia_porAtributo() {
		return "Inyeccion por:   [B]. '#Atributo'";
	}

	@Override
	public String getInyeccionDependencia_porSetter() {
		return "Inyeccion por:   [B]. '#MetodoSet'";
	}

	@Override
	public String getInyeccionDependencia_porConstructor() {
		return "Inyeccion por:   [B]. '#Constructor'";
	}

}
