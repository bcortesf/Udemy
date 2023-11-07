package com.company.beans11;

import com.company.principios.InyeccionDependencia.IEquipo;

public class Jugador {
	
	//ATRIBUTO
	private int numero;
	private String nombre;
	private IEquipo equipo;
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
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
	
	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	
}
