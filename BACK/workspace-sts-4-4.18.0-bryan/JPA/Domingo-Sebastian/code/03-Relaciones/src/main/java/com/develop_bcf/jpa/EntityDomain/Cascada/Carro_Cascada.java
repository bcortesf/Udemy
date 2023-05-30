package com.develop_bcf.jpa.EntityDomain.Cascada;

import com.develop_bcf.jpa.EntityDomain.Persona;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Carro_Cascada {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;		//propiedad-sintetica = NoExistente
	private String placa;	//propiedad-natural   = Existe
	private String modelo;

	/*1.1.Crear "FOREIGN-KEY" de la EntidadRelacion; a lo SQL*/
	//ForeignKey = LLaveForanea
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	private Persona propietarioFK; //MUCHOS<Carro's> pertenecen a--> UNA<Persona>

	
	public Carro_Cascada() {
		super();
	}
	public Carro_Cascada(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
	}
	public Carro_Cascada(String placa, String modelo, Persona propietarioFK) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.propietarioFK = propietarioFK;
	}


	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Persona getPropietarioFK() {
		return propietarioFK;
	}
	public void setPropietarioFK(Persona propietarioFK) {
		this.propietarioFK = propietarioFK;
	}


	@Override
	public String toString() {
		return "Carro [id=" + id + ", placa=" + placa + ", modelo=" + modelo + ", propietarioFK=" + propietarioFK + "]";
	}
	public String toString_2() {
		return "Carro [id=" + id + ", placa=" + placa + ", modelo=" + modelo + "]";
	}

}
