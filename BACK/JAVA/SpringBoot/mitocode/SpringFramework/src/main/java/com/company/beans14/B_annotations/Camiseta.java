package com.company.beans14.B_annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



@Component
public class Camiseta {

	private int id;
	private int numero;
	
	@Autowired  /** -> busca que la clase a la que llama tenga de encabezado @Component */
	private Marca marca;


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Marca getMarca() {
		return marca;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}


	@Override
	public String toString() {
		return "Camiseta [id=" + id + ", numero=" + numero + ", marca=" + marca + "]";
	}

}
