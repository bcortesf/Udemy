package com.company.di.domainEntityPojo;

import java.io.Serializable;


/**
 * Un <ItemFactura> TIENE-UNA <Factura>
 * 		-Pero la relacion de atributo "tipo lista",  esta relacionada desde <Factura>
 * Un <Factura> TIENE-MUCHOS <ItemFactura>
 * 		- (RELACION-MUCHOS <ItemFactura>): absorbe al atributo <Factura>
 * 
 * Un <ItemFactura> TIENE-UN <Producto>
 * Un <Producto> TIENE-MUCHOS <ItemFactura>
 * 		- (RELACION-MUCHOS <ItemFactura>): absorbe al atributo <Producto>
 */
public class ProductoFactura_ItemFactura implements Serializable{

	private static final long serialVersionUID = 1L;
	//private int idProductoFactura;
	private Producto producto;
	private Integer cantidad;


	//Alt+Shif+S	:abrir comandos del source
	public ProductoFactura_ItemFactura() {}
	public ProductoFactura_ItemFactura(Producto producto, Integer cantidad) {
		this.producto = producto;
		this.cantidad = cantidad;
	}

	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantidad() {
		return cantidad;
	}
	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}


	/**
	 * Calcular importe o calcular total
	 * @return 
	 * total producto x 2 = el doble
	 */
	public Double CalcularImporteDoble() {
		return (producto.getPrecio() * cantidad) * 2;
	}

}
