package com.empresabcf.sb.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresabcf.sb.di.app.models.domainPojoEntity.Factura;

@Controller
@RequestMapping(path = "/factura")
public class FacturaController {
	
	@Autowired
	Factura facturaDAO; //apuntarle siempre a un Generico (Interfaz ó abstract.class)

	//	http://localhost:8080/factura/verDetalle
	@GetMapping(path = {"/verDetalle"})
	public String getFactura(Model model) {
		model.addAttribute("titulo", "FACTURA - ¡ver detalle!");
		model.addAttribute("factura", facturaDAO);
		
		model.addAttribute("itemsFactura", facturaDAO.getItems());
		return "facturas/ver_detalle";//	/2-spring-boot-di/src/main/resources/templates.../facturas/findex.html
		//   "./facturas/ver_detalle";
	}

}
