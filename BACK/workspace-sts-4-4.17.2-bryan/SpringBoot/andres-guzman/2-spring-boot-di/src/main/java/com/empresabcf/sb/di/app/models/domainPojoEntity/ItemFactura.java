package com.empresabcf.sb.di.app.models.domainPojoEntity;


public class ItemFactura {
	/**
	 * Un <ItemFactura> TIENE-UNA <Factura>
	 * 		-Pero la relacion de atributo tipo lista, esta relacionada desde <Factura>
	 * Un <ItemFactura> TIENE-UN <Producto>
	 * 		-La relacion (UNO a MUCHOS): 1<Producto>..**<ItemFactura>
	 * 		 absorbe el atributo <Producto>
	 */
	private Producto producto;//<1>
	
	private Integer cantidad;

	
	//Alt+Shif+S	:abrir comandos del source
	public ItemFactura(Producto producto, Integer cantidad) {
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
	
	/*
	 * Calcular importe o calcular total
	 */
	public Double CalcularImporte() {
		return (this.producto.getPrecio() * this.cantidad) + 1;
	}

}
