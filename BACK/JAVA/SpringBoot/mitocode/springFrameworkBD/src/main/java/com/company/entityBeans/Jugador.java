package com.company.entityBeans;

public class Jugador {

	private int id;
	private String nombre;
	private Equipo equipo;
	private Camiseta camiseta;

	/*GETTERS & SETTERS*/
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
	public Equipo getEquipo() {
		return equipo;
	}
	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	public Camiseta getCamiseta() {
		return camiseta;
	}
	public void setCamiseta(Camiseta camiseta) {
		this.camiseta = camiseta;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + ", camiseta=" + camiseta + "]";
	}
	
}
