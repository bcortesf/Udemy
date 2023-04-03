package com.empresabcf.sb.di.app.models.domainPojoEntity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/* @RequestScope
 * 		CON+ @RequestScope:  Nuevos <Cliente.class>, asociados a Nuevas<Factura.class>
 * 		SIN- @RequestScope:  Mismo <Cliente.class>, asociados a Nuevas<Factura.class>;		SERIA UN ERROR, PORQUE SON MUCHOS CLIENTES
 */
@RequestScope
@Component
public class Cliente {
	/**
	 * Un <Cliente> TIENE-MUCHAS <Factura>
	 * 		- En <Factura> esta el atributo <Cliente>
	 * 		  porque      <Factura>   es la tabla intermedia entre
	 * 		  <Cliente>...............<ItemFactura>
	 */
	private int id;
	
	@Value(value = "${domain_cliente_nombre}")		//inyectado-de =>  /2-spring-boot-di/src/main/resources/application.properties
	private String nombre;
	@Value(value = "${domain_cliente_apellido}")	//inyectado-de =>  /2-spring-boot-di/src/main/resources/application.properties
	private String apellido;
	
	
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
}
