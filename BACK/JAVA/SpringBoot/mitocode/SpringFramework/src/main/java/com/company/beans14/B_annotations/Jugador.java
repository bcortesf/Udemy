package com.company.beans14.B_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.company.beans14.A2_xml.IEquipo;

@Component(value = "Jugador")
public class Jugador {

	private int id;
	private String nombre;

	@Autowired  /** -> busca que la clase a la que llama tenga de encabezado @Component, en este caso a las clasesHIJAS que lo implementen o hereden */
	@Qualifier(value = "brasil_por_defecto")
	private IEquipo equipo;
	@Autowired /** -> busca que la clase a la que llama tenga de encabezado @Component */
	private Camiseta camiseta;


	// GETTERS && SETTERS
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

	// 
	@Override
	public String toString() {
		return "Jugador [id=" + id + ", nombre=" + nombre + ", equipo=" + equipo + ", camiseta=" + camiseta + "]";
	}
	
	// funcionalidades-externas
	public void registrar() {
		System.out.println("***REGISTRAR JUGADOR EN BASE-DATOS***");
		System.out.println("");
		System.out.println("");
		System.out.println("");
	}
	
}
