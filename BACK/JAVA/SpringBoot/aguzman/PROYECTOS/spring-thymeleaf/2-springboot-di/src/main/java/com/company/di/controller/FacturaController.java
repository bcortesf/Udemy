package com.company.di.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.di.domainEntityPojo.Factura;


@Controller
@RequestMapping(path = {"/facturaInvoice"})
public class FacturaController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;
	
	@Autowired
	private Factura facturaDAO; //apuntarle siempre a un Generico (Interfaz ó abstract.class)

	@GetMapping(path = {"/ver"})
	public String detalleFactura(Model model) {
		model.addAttribute("title", "FACTURA - ¡ver detalle!");
		model.addAttribute("factura", facturaDAO);
		model.addAttribute("itemsFactura", facturaDAO.getItems());
		
		double subtotal = facturaDAO.getItems().stream()
				.map(pf -> pf.getProducto().getPrecio())
				.reduce(0.0, (acumulador, precio) -> acumulador + precio);
		double iva16x100to = Math.round( (subtotal * 0.16) * 100.0) / 100.0; // (subtotal * 0.16) 
		model.addAttribute("subtotal", subtotal);
		model.addAttribute("iva", iva16x100to);	

		return "factura/verDetalle";//		/2-springboot-di/src/main/resources/templates/factura/verDetalle.html
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/8277320?start=39#notes
	 * @ModelAttribute
	 */
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		return this.DOMINIO;
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////

}
