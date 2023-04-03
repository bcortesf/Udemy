package com.empresabcf.sb.di.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.empresabcf.sb.di.app.models.services.IServicio;
import com.empresabcf.sb.di.app.models.services.Servicio_SinInyeccionDependencia;

@Controller
public class IndexController {
	
	/***********
	 * ATRIBUTES
	 **********/
	private IServicio servicioSinDI;
	
	@Qualifier(value = "servicioDI2")
	@Autowired private IServicio atributo_ServicioConDI;
	
	@Qualifier(value = "servicioDI2")
	private IServicio setter_ServicioConDI; //instanciado de forma automatica por metodo setter --> this.setSet_ServicioConDI

	@Qualifier(value = "servicioDI3")
	@Autowired
	private IServicio appConfig_ServicioConDI3;

	/*************
	 * CONSTRUCTOR
	 ************/
	private IServicio constructor_ServicioConDI;
	@Autowired
	public IndexController(
			@Qualifier(value = "servicioDI2")
			IServicio constructor_ServicioConDI) {
		this.constructor_ServicioConDI = constructor_ServicioConDI;
		this.servicioSinDI = new Servicio_SinInyeccionDependencia();
	}

	/******
	 * APIS
	 *****/
	@GetMapping(path = {"/", "", "index"})
	public String paginaPrincipal(Model model) {
		model.addAttribute("sin_DI_InyeccionDependencia", this.servicioSinDI.operacion());
		
		model.addAttribute("con_DI_InyeccionDependencia", this.atributo_ServicioConDI.operacion());
		model.addAttribute("conDI_por_ATRIBUTO", this.atributo_ServicioConDI.getInyeccionDependenciaPorAtributo());
		model.addAttribute("conDI_por_METODOSET", this.setter_ServicioConDI.getInyeccionDependenciaPorSetter());
		model.addAttribute("conDI_por_CONSTRUCTOR", this.constructor_ServicioConDI.getInyeccionDependenciaPorConstructor());
		
		model.addAttribute("conDI_ConfigurationBean", this.appConfig_ServicioConDI3.getInyeccionDependenciaPorAtributo());
		return "index";//	/2-spring-boot-di/src/main/resources/templates/index.html
	}

	/**********
	 * SETTER'S
	 *********/
	
	@Qualifier(value = "servicioDI2")
	@Autowired
	public void setSet_ServicioConDI(IServicio set_ServicioConDI) {
		this.setter_ServicioConDI = set_ServicioConDI;
	}
	
	
	
}
