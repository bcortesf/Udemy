package com.develop_bcf.jpa.entityDomain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonaIDENTITY {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String pais;

	public PersonaIDENTITY() {
	}
	public PersonaIDENTITY(String nombre, String pais) {
		super();
		this.nombre = nombre;
		this.pais = pais;
	}

	// Alt + Shift + s
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
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", pais=" + pais + "]";
	}
//	@Override
//	public int hashCode() {
//		return Objects.hash(getId());
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (!(obj instanceof PersonaIDENTITY))
//			return false;
//		PersonaIDENTITY other = (PersonaIDENTITY) obj;
//		return getId() == other.getId();
//	}

}
