package com.company.di.domainEntityPojo;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * Una <Factura> TIENE-UN <Cliente>
 * 
 * 1.1.     Una   <Factura> TIENE-MUCHOS     <Productos> 
 *      &&   Un <Producto> ESTA-EN-MUCHAS <Facturas>
 * 	 - Relación (MUCHOS a MUCHOS) genera nueva tabla intermedia <ItemFactura>
 * 
 * 1.2. Una <Factura> TIENE-MUCHOS <ItemFactura>   ====> tiene muchos (items o lineas)
 * 		MUCHOS: [es una lista]
 * 		<ItemFactura> al ser una lista, no se puede instanciar con @Autowired, 
 * 			- porque la class "List" es de un desarrollo externo o un tercero.
 *  
 *  ========================================================================;
 *  ========================================================================;
 *  @RequestScope :sirve para objetos que mantienen estado en sus atributos, stateful, 
 *                                es decir que sus atributos son poblados con datos propios del usuario y no de otros usuarios.
 *                                Al ser del contexto del request es único para cada petición http de un usuario en particular
 *  EJEMPLO:     objetos que mantienen configuraciones y/o datos del usuario y queremos que 
 *                       esa información dure solo un request
 *  @RequestScope  ~~ Nuevas Facturas
 * 		<Se-elimina-la-instancia-SINGLETON>   ==>   y se convierte en CREACION-INSTANCIAS-NUEVAS, 
 *         por cada llamado al componente <FACTURA>.
 *         
 * 		Aplicado en @PostConstruct; Por cada peticion  "localhost:8080/facturaInvoice/ver"
 *         - 1. Construye BEAN <FACTURA>
 *         - 2. Destruye BEAN <FACTURA>
 *   ========================================================================;
 *  ========================================================================;
 *  @SessionScope :  si necesitamos que dure más de un request http, modificamos el contexto a sesiones
 *                                El tiempo de vida es desde que iniciamos sesion, y dura hasta:
 *                                (cerrar sesion, timeout sesion, sesion invalida), cerrar el navegador
 *                                se implementa en:
 *                                -  un carro de compras
 *                                - Autenticacion o sesión de usuarios
 *                                Debe implementar [implements Serializable], para convertir el objeto en una secuencia de bytes
 *                                para poder  guardarlo en objetos de almacenamiento (java, objetoJSON, objetoXML, sesionesHTTP, ETC)
 *                              
     @SessionScope
     public class Factura implements Serializable {
    	private static final long serialVersionUID = 654651;
     }
 *   ========================================================================;
 *  ========================================================================;
 *  @ApplicationScope :Es el que esta pordefecto, asi no se anote y es el singleton
 */

@RequestScope
@Component //instancia-principal:	/2-springboot-di/src/main/java/com/company/di/controller/FacturaController.java
public class Factura implements Serializable{
	Logger LOG = LoggerFactory.getLogger(getClass());

	private static final long serialVersionUID = 1L;
	private int idFactura;
	@Value(value = "${domain_factura_descripcion}")
	private String descripcion;
	@Autowired Cliente cliente;
	
	/*LA INSTANCIA DE CLASE ProductoFactura_ItemFactura,  se hace en : APP-CONFIG
	 * /2-springboot-di/src/main/java/com/company/di/AppConfig.java       ==>  @Primary - "OPCION 1"
	 * */
	
	/*						OPCION 1						*/
	@Autowired
	private List<ProductoFactura_ItemFactura> items;
	/*						OPCION 2						*/
	/*@Autowired
	@Qualifier(value = "itemsFactura1")//:si tengo mas de dos implementaciones; especificar a cual apuntar
//	@Qualifier(value = "itemsFactura2")//:si tengo mas de dos implementaciones; especificar a cual apuntar
	private List<ProductoFactura_ItemFactura> items;*/


	public Factura() {}
	public Factura(int idFactura, String descripcion, Cliente cliente) {
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.cliente = cliente;
	}


	//---------------------------------------------------------------------------------------------------
										//CICLO-DE-VIDA-BEAN
	/**
	 * Usada para inicializar o cambiar el valor de algun atributo.
	 * Se ejecuta:
	 * 	-  Despues de crear o construir el componente <FACTURA>
	 *     -  Despues de inyectar la dependencia              <CLIENTE>
	 */
	@PostConstruct
	public void inicializar() {
		cliente.setApellido( cliente.getApellido().concat(" - ").concat("BCFz") );
		String direccion = "<span class=\"text-info\">Carrera 30</span>";
		descripcion = descripcion.concat(" - ").concat(direccion);
	}
	/**
	 * Se ejecuta:
	 * 	-  Despues de darle STOP a la aplicacion
	 *     -  por ejemplo:  cerrar una conexion de la BD
	 */
	@PreDestroy
	public void destruir() {
		LOG.info( "Factura destruida, campo<CLI.APELLIDO> :    ".concat(cliente.getApellido()) );
//		LOG.info( "Factura destruida, campo<DESCRIPCION>:    ".concat(descripcion) );
	}
	//---------------------------------------------------------------------------------------------------


	public int getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
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
	public List<ProductoFactura_ItemFactura> getItems() {
		return items;
	}
	public void setItems(List<ProductoFactura_ItemFactura> items) {
		this.items = items;
	}

}
