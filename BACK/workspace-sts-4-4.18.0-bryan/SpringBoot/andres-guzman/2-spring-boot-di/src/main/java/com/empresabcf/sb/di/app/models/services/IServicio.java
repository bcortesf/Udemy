package com.empresabcf.sb.di.app.models.services;

public interface IServicio {
	public String operacion();
	
	public String getInyeccionDependenciaPorAtributo();
	public String getInyeccionDependenciaPorSetter();
	public String getInyeccionDependenciaPorConstructor();
}
