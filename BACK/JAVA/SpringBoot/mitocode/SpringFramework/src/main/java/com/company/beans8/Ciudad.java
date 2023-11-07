package com.company.beans8;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Ciudad {
	private String nombre;
	
	////////////////////////////////////
	@PostConstruct
	public void initBean() {
		System.out.println(Ciudad.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Ciudad.class.getSimpleName() + "]");
	}
	@PreDestroy
	public void destroyBean() {
		System.out.println(Ciudad.class.getPackageName() +"\t : Bean[" + Ciudad.class.getSimpleName() + "] a punto de ser destruido");
	}
	////////////////////////////////////
	
	public Ciudad() {
		System.out.print("    C- ejecucion Constructor Ciudad\n");
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Ciudad [nombre=" + nombre + "]";
	}

}
