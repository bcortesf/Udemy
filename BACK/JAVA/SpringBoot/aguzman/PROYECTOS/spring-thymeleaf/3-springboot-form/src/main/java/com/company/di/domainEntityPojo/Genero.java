package com.company.di.domainEntityPojo;

import jakarta.validation.constraints.NotBlank;

public class Genero {

	@NotBlank(message = "Debe seleccionar un Genero xD")
		private String codigo;  //M
	private String nombre ;//Masculino


	public Genero() {}
	public Genero(String codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		
	}

	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Genero [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
