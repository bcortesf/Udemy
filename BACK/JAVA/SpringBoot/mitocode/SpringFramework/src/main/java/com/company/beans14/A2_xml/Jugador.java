package com.company.beans14.A2_xml;

import com.company.beans14.A1_xml.Camiseta;

public class Jugador {

	private int id;
	private String nombre;
	private IEquipo equipo;
	private Camiseta camiseta;

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
	public IEquipo getEquipo() {
		return equipo;
	}
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
	public Camiseta getCamiseta() {
		return camiseta;
	}
	public void setCamiseta(Camiseta camiseta) {
		this.camiseta = camiseta;
	}


	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + ", camiseta=" + camiseta + "]";
	}
	
}
