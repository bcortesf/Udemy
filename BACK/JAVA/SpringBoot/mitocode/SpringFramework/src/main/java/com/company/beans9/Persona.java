package com.company.beans9;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Persona implements InitializingBean, DisposableBean {

	private int id;
	private String nombre;
	private Pais pais;
	private Ciudad ciudad;
	
	////////////////////////////////////
	//EQUIVALENCIA DE : public void initBean() {..}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(Persona.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Persona.class.getSimpleName() + "]");
		
	}
	//EQUIVALENCIA DE : public void destroyBean() {..}
	@Override
	public void destroy() throws Exception {
		System.out.println(Persona.class.getPackageName() +"\t : Bean[" + Persona.class.getSimpleName() + "] a punto de ser destruido");
	}
	////////////////////////////////////
	
	public Persona() {
		System.out.print("    A- ejecucion Constructor Persona\n");
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}

}
