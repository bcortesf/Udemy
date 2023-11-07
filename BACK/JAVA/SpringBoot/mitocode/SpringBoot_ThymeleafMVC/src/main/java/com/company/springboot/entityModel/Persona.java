package com.company.springboot.entityModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * https://www.youtube.com/watch?v=C3Xwu7wuYAo&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&index=9
 * @Entity     :mismo nombre de la tabla en BD
 * @Id            :Llave primaria, BD
 * @Column  :[name: nombre-columna BD]
 * 					[length: tamaño-columna-en-caracteres BD]
 * 
 * @E  :  
 */

@Entity
public class Persona {
	
	@Id //automaticamente en BD, configura mayusculas por "_"   :id_persona
	private int idPersona;
	@Column(name = "nombre", length = 50)
	private String nombre;

	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [idPersona=" + idPersona + ", nombre=" + nombre + "]";
	}
}
