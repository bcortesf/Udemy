package com.develop_bcf.jpa.EntityDomain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Persona {
	
	@Id //@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String nombre; //primaryKey

	private String municipio;

	@Column(unique = true)
	private String dni;


	public Persona() {
	}
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMunicipio() {
		return municipio;
	}
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", municipio=" + municipio + ", dni=" + dni + "]";
	}

}
