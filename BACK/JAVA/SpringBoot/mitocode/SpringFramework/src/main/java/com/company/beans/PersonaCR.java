package com.company.beans;




public class PersonaCR {

	private int id;
	private String nombre;
	private PaisAO pais;
	private CiudadAO ciudad;

    /* CR = CONSTRUCTOR */
	public PersonaCR(int id, String nombre, PaisAO pais, CiudadAO ciudad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
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
	public PaisAO getPais() {
		return pais;
	}
	public void setPais(PaisAO pais) {
		this.pais = pais;
	}
	public CiudadAO getCiudad() {
		return ciudad;
	}
	public void setCiudad(CiudadAO ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}

}
