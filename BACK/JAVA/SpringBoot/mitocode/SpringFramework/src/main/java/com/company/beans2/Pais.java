package com.company.beans2;

import com.company.beans.CiudadAO;

public class Pais {
	private String nombre;
	private CiudadAO ciudad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public CiudadAO getCiudad() {
		return ciudad;
	}

	public void setCiudad(CiudadAO ciudad) {
		this.ciudad = ciudad;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", ciudad=" + ciudad + "]";
	}
	
}
