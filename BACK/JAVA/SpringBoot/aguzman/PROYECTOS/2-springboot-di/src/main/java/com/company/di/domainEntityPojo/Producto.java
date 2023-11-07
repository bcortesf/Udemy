package com.company.di.domainEntityPojo;

import java.io.Serializable;

/**
 * 1.1.     Un <Producto> ESTA-EN-MUCHAS <Facturas> 
 *      && Una <Factura> TIENE-MUCHOS    <Productos>
 * 	 - Relación (MUCHOS a MUCHOS) genera nueva tabla intermedia <ItemFactura>
 * 
 * 1.2. Una <Producto> ESTA-EN-MUCHOS <ItemFactura> (items o lineas)
 */
public class Producto implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idProducto;
	private String nombre;
	private Double precio;
	

	public Producto() {}
	public Producto(int idProducto, String nombre, Double precio) {
		super();
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.precio = precio;
	}

	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
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
	public void setMarca(Double precio) {
		this.precio = precio;
	}

}
