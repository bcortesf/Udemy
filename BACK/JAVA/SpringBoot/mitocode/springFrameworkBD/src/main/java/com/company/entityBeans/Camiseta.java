package com.company.entityBeans;

public class Camiseta {

	private int id;
	private int numero;
	private Marca marca;

	/*GETTERS & SETTERS*/
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
	
	////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Camiseta [id=" + id + ", numero=" + numero + ", marca=" + marca + "]";
	}

}
