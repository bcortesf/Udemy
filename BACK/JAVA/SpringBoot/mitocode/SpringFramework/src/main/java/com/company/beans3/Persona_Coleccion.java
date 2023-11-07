package com.company.beans3;



public class Persona_Coleccion {

	private int id;
	private String nombre;
	private Pais_Coleccion pais;

	public Persona_Coleccion(int id, String nombre, Pais_Coleccion pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
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
	public Pais_Coleccion getPais() {
		return pais;
	}
	public void setPais(Pais_Coleccion pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
	}

}
