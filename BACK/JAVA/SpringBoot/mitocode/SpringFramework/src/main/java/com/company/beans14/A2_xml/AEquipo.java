package com.company.beans14.A2_xml;

public abstract class AEquipo {
	
	protected int id;
	protected String nombre;

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
		return "AbstractEquipo [id=" + id + ", nombre=" + nombre + "]";
	}

}
