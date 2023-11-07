package com.company.beans14.B_annotations;

import org.springframework.stereotype.Component;

@Component
public class Marca {
	
	private int id;
	private String nombre;

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


	@Override
	public String toString() {
		return "Marca [id=" + id + ", nombre=" + nombre + "]";
	}

}
