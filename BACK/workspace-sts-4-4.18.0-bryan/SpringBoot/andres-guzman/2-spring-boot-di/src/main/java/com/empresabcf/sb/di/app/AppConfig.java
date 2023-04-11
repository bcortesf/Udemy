package com.empresabcf.sb.di.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.empresabcf.sb.di.app.models.domainPojoEntity.ItemFactura;
import com.empresabcf.sb.di.app.models.domainPojoEntity.Producto;
import com.empresabcf.sb.di.app.models.services.IServicio;
import com.empresabcf.sb.di.app.models.services.Servicio_ConInyeccionDependencia3;

@Configuration
public class AppConfig {
	
	@Bean(value = {"servicioDI3"})
	public IServicio registrar_ServicioConInyeccionDependencia3() {
		return new Servicio_ConInyeccionDependencia3();
	}
	
	/**
	 * Como una LIST no se puede instanciar con @Autowired de forma directa, entonces
	 * Para los Items de la <Factura>,.. es decir (List<ItemFactura>)
	 * Se registra de manera independiente
	 */
	@Bean(value = "itemsFactura")
	public List<ItemFactura> registrarItems() {
		Producto producto1 = new Producto("Camara sony"              , 100.0);
		Producto producto2 = new Producto("Bicicleta Optimus ring 29", 200.0);
		
		ItemFactura item1 = new ItemFactura(producto1, 3);// 1<ItemFactura> esta asociado a 1<Producto>
		ItemFactura item2 = new ItemFactura(producto2, 2);// 1<ItemFactura> esta asociado a 1<Producto>
		return Arrays.asList(item1, item2);
	}
	
	@Bean(value = {"itemsFacturaOficina"})
	public List<ItemFactura> registrarItemsOficina() {
		Producto producto1 = new Producto("Monitor LG LCD 28p"   , 250.0);
		Producto producto2 = new Producto("Monitor Samsung 34p"  , 500.0);
		Producto producto3 = new Producto("Mouse Corsair RGB"    , 80.0);
		Producto producto4 = new Producto("Teclado Logitech G203", 300.0);
		
		// 1<ItemFactura> esta asociado a 1<Producto>
		ItemFactura item1 = new ItemFactura(producto1, 2);
		ItemFactura item2 = new ItemFactura(producto2, 1);
		ItemFactura item3 = new ItemFactura(producto3, 1);
		ItemFactura item4 = new ItemFactura(producto4, 1);
		return Arrays.asList(item1, item2, item3, item4);
	}
}



