package com.company.di;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.company.di.domainEntityPojo.Producto;
import com.company.di.domainEntityPojo.ProductoFactura_ItemFactura;
import com.company.di.service.IServicio;
import com.company.di.service.Servicio_TipoInyeccionDependenciaC_impl;

@Configuration
public class AppConfig {

	@Bean(name = {"servicioDI_C"})
	public IServicio registrar_Servicio_TipoInyeccionDependenciaC_impl() {
		return new Servicio_TipoInyeccionDependenciaC_impl();
	}
	//----------------------------------------------------------------------------------
	//----------------------------------------------------------------------------------

	/**
	 * Como un LIST<>, no se puede instanciar con @Autowired con anotacion, entonces:
	 * - Para los  (items: <ProductoFacturaItemFactura>) de la clase <Factura>,
	 *   se registran de manera independiente. 
	 */
	@Bean(value = "itemsFactura1")
	@Primary	// /2-springboot-di/src/main/java/com/company/di/domainEntityPojo/Factura.java  ==> "private List<ProductoFactura_ItemFactura> items;";
	                   //Factura.java  ==> solo aplica para "OPCION1";
    				   //Factura.java  ==> Para "OPCION2"; quitar este @Primary,  porque se maneja los @Qualifier
	public List<ProductoFactura_ItemFactura> registrar_FacturaProducto1() {
		Producto producto1 = new Producto(1, "Cama", 100.0);//(id, nombre, precio)
		Producto producto2 = new Producto(2, "Sofa"  , 200.0);//(id, nombre, precio)
		
		// <ItemFactura> TIENE-UN <Producto>
		ProductoFactura_ItemFactura item1 = new ProductoFactura_ItemFactura(producto1, 3);//(producto, cantidadProducto)
		ProductoFactura_ItemFactura item2 = new ProductoFactura_ItemFactura(producto2, 2);//(producto, cantidadProducto)
		return Arrays.asList(item1, item2);
	}
	
	@Bean(value = "itemsFactura2")
	public List<ProductoFactura_ItemFactura> registrar_FacturaProducto2() {
		Producto producto1 = new Producto(1, "Pantalla"  , 250.0);//(id, nombre, precio)
		Producto producto2 = new Producto(2, "Teclado"   , 500.0);//(id, nombre, precio)
		Producto producto3 = new Producto(3, "Mouse"    , 80.0);//(id, nombre, precio)
		Producto producto4 = new Producto(4, "Escritorio", 40.0);//(id, nombre, precio)
		
		// <ItemFactura> TIENE-UN <Producto>
		ProductoFactura_ItemFactura item1 = new ProductoFactura_ItemFactura(producto1, 3);//(producto, cantidadProducto)
		ProductoFactura_ItemFactura item2 = new ProductoFactura_ItemFactura(producto2, 2);//(producto, cantidadProducto)
		ProductoFactura_ItemFactura item3 = new ProductoFactura_ItemFactura(producto3, 1);//(producto, cantidadProducto)
		ProductoFactura_ItemFactura item4 = new ProductoFactura_ItemFactura(producto4, 4);//(producto, cantidadProducto)
		return Arrays.asList(item1, item2, item3, item4);
	}

}
