package com.company.beans8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Pais {
	private String nombre;
	
	////////////////////////////////////
	@PostConstruct
	public void initBean() {
		System.out.println(Pais.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Pais.class.getSimpleName() + "]");
	}
	@PreDestroy
	public void destroyBean() {
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
