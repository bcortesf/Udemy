package com.develop_bcf.jpa.EntityDomain;

import java.util.Set;
import java.util.HashSet;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Persona {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer cedula;
	private String nombre;

	/*1.2.Referenciar de de <Carro.class> la "FOREIGN-KEY"; para que JPA entienda */
	@OneToMany(mappedBy = "propietarioFK") //Carro.propietarioFK
	private Set<Carro> coches = new HashSet<Carro>(); //UNA<Persona> posee ---> MUCHOS<Carro's>

	
	public Persona() {
	}
	public Persona(Integer cedula, String nombre) {
		this.cedula = cedula;
		this.nombre = nombre;
	}


	public Integer getCedula() {
		return cedula;
	}
	public void setCedula(Integer cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Set<Carro> getCoches() {
		return coches;
	}
	public void setCoches(Set<Carro> coches) {
		this.coches = coches;
	}

	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + "]";
	}
	public String toString_2() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", coches=" + coches + "]";
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getNombre() == null) ? 0 : getNombre().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona other = (Persona) obj;
		if (getNombre() == null) {
			if (other.getNombre() != null)
				return false;
		} else if (!getNombre().equals(other.getNombre()))
			return false;
		return true;
	}
	
}
