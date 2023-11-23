package com.company.di.domainEntityPojo;

import jakarta.validation.constraints.NotNull;

public class Ciudad {

	private Integer id;
	private String codigo;  //BTA
	private String nombre ;//Bogotá


	public Ciudad() {}
	public Ciudad(Integer id, String codigo, String nombre) {
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
	}

	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		return "Ciudad [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + "]";
	}

}
