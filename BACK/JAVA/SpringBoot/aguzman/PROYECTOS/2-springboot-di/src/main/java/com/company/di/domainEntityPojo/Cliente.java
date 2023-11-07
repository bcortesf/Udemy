package com.company.di.domainEntityPojo;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

/**
 * Un <Cliente> TIENE-MUCHAS <Factura>
 * 		- (RELACION-MUCHOS <Factura>): absorbe al atributo <Cliente>
 * ========================================================
 * ========================================================
 * @RequestScope
 * 		CON+ @RequestScope:  Nuevos <Cliente.class>, asociados a Nuevas<Factura.class>
 * 		SIN   - @RequestScope:  Mismo <Cliente.class>, asociados a Nuevas<Factura.class>;		SERIA UN ERROR, PORQUE SON MUCHOS CLIENTES
 */
@RequestScope

@Component
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	private int idCliente;

	@Value(value = "${domain_cliente_nombre}")	//inyectado-de =>  /2-springboot-di/src/main/resources/application.properties
	private String nombre;
	@Value(value = "${domain_cliente_apellido}")	//inyectado-de =>  /2-springboot-di/src/main/resources/application.properties
	private String apellido;


	public Cliente() {}
	public Cliente(int idCliente, String nombre, String apellido) {
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
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
