package com.company.beans9;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Pais implements InitializingBean, DisposableBean {
	private String nombre;
	
	////////////////////////////////////
	//EQUIVALENCIA DE : public void initBean() {..}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Pais.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Pais.class.getSimpleName() + "]");
		
	}
	//EQUIVALENCIA DE : public void destroyBean() {..}
	@Override
	public void destroy() throws Exception {
		System.out.println(Pais.class.getPackageName() +"\t : Bean[" + Pais.class.getSimpleName() + "] a punto de ser destruido");
	}
	////////////////////////////////////
	
	public Pais() {
		System.out.println("    B- ejecucion Constructor Pais\n");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + "]";
	}

}
