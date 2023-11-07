package com.company.beans9;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Ciudad implements InitializingBean, DisposableBean {
	private String nombre;
	
	////////////////////////////////////
	//EQUIVALENCIA DE : public void initBean() {..}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Ciudad.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Ciudad.class.getSimpleName() + "]");
		
	}
	//EQUIVALENCIA DE : public void destroyBean() {..}
	@Override
	public void destroy() throws Exception {
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
