package com.empresabcf.sb.di.app.models.domainPojoEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/*
 * @SessionScope
 * public class Factura implements Serializable {
 * 	private static final long serialVersionUID = 654651;
 * }
 */

/* @RequestScope
 * 		Se elimina la instancia SINGLETON y se convierte en creacion de instancias nuevas, cada ves que llame el componente
 * 		Aplicado en @PostConstruct, para campos <CLIENTE.NOMBRE><THIS.DESCRIPCION>
 * 		NOTA: @RequestScope ~~ Nuevas Facturas
 */
@RequestScope
@Component
public class Factura {
	/**
	 * 1.Una <Factura> TIENE-UN <Cliente>,  la relacion (UNO a MUCHOS) absorve  a <Cliente>
	 * 
	 * 2.Una <Factura> TIENE-MUCHOS <Productos>
	 * 		- Relación (MUCHOS a MUCHOS) genera nueva tabla intermedia <ItemFactura></ItemFactura>
	 * 2.1.Una <Factura> TIENE-MUCHOS <ItemFactura> (items o lineas)
	 * 		- <ItemFactura> al ser una lista, no se puede instanciar con @Autowired, 
	 *        porque la class "List" es de un tercero
	 * 		  entonces tenemos que crear un CONSTRUCTOR dentro de <ItemFactura>
	 */
	private int id;

	@Value(value = "${domain_factura_descripcion}")		//inyectado-de =>  /2-spring-boot-di/src/main/resources/application.properties
	private String descripcion;
	
	@Autowired
	private Cliente cliente;       //<1>
	
	@Autowired	                               //:Si tuviera una sola implementacion, en "AppConfig.java" se reemplaza "@Qualifier" por "@Primary"
	//ESCOGER-UNO-DE-LOS-DOS-@QUALIFIER
	@Qualifier(value = "itemsFactura")	       //:si tengo dos mas implementaciones; ESCOGO-ESTA-A-MODO-PERSONAL
//	@Qualifier(value = "itemsFacturaOficina")  //:si tengo dos mas implementaciones; ESCOGO-ESTA-A-MODO-PERSONAL
	private List<ItemFactura> items;//<2.1>;	/2-spring-boot-di/src/main/java/com/empresabcf/sb/di/app/AppConfig.java


	/**
	 * Usada al terminar de construir el componente; para inicializar o cambiar el valor de algun atributo
	 * Se ejecuta justo despues de de crear el objeto
	 * y se ejecuta justo despues de inyectar la dependencia  
	 */
	@PostConstruct
	public void inicializar() {
		cliente.setNombre( cliente.getNombre().concat(" ").concat("BCF.") );
		descripcion = descripcion.concat("  -  DEL_CLIENTE: ").concat("<BryanCFz>");
	}

	/**
	 * Se ejecuta cuando le doy STOP a la aplicacion
	 * por ejemplo cerrar una conexion de la BD
	 */
	@PreDestroy
	public void destruir() {
//		System.out.println( "Factura destruida, campo<DESCRIPCION>:    ".concat(descripcion) );
		System.out.println( "Factura destruida, campo<CLI.NOMBRE>:    ".concat(cliente.getNombre()) );
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}

}
