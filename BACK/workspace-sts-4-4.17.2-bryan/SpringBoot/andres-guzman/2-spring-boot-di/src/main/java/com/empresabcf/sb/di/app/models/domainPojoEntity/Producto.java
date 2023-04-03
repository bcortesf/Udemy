package com.empresabcf.sb.di.app.models.domainPojoEntity;



public class Producto {
	/**
	 * Un <Producto> TIENE-MUCHOS <ItemFactura>
	 * 		-Pero la relacion de atributo, esta relacionada desde <ItemFactura>
	 */
	private String nombre;
	private Double precio;


	public Producto(String nombre, Double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}	

}
