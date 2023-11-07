package com.company.di.service;

import org.springframework.stereotype.Service;

/*		FORMA-1		*/
//@Component(value = "servicioDI_A")
/*		FORMA-2		*/
//@Service(value = "servicioDI_A")
/*		FORMA-3		*/
//@Service @Qualifier(value = "servicioDI_A")

@Service(value = "servicioDI_A")
public class Servicio_TipoInyeccionDependenciaA_impl implements IServicio {

	@Override
	public String getInyeccionDependencia_porAtributo() {
		return "Inyeccion por:   [A]. '#Atributo'";
	}

	@Override
	public String getInyeccionDependencia_porSetter() {
		return "Inyeccion por:   [A]. '#MetodoSet'";
	}

	@Override
	public String getInyeccionDependencia_porConstructor() {
		return "Inyeccion por:   [A]. '#Constructor'";
	}

}
