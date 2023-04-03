package com.empresabcf.sb.di.app.models.services;


public class Servicio_SinInyeccionDependencia implements IServicio {
	
	@Override
	public String operacion() {
		return "Ejecutando algún proceso importante__sinInyeccion...";
	}

	@Override
	public String getInyeccionDependenciaPorAtributo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInyeccionDependenciaPorSetter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getInyeccionDependenciaPorConstructor() {
		// TODO Auto-generated method stub
		return null;
	}

}
