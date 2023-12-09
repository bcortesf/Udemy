package com.company.manejoError.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@GetMapping(path = {"/princicipal"})//RUTA-MAL-ESCRITA-EN-NAVEGADOR : Error<404>
	public String error500(Model model) {
		model.addAttribute("motivoPersonalizado", "LA ruta o el nombreHTML no lo encuentra ó esta mal escrito ");

		/*PRUEBA-1*/
//		return "paginaPrincipal";//HTML-NO-EXISTENTE : Error<500>


		/*PRUEBA-2.1*/ @SuppressWarnings("unused")
//		Integer valor =  100/0;
//		return "paginaPrincipal";//HTML : Error<500> - ARITMETICO POR DIVISION
		
		/*PRUEBA-2.2*/
		Integer valor =  Integer.parseInt("34x");
		return "paginaPrincipal";//HTML : Error<500> - FORMATO NUMERICO
	}



	//////////////////////////////////////////////////////////////////////
	/**
	* https://www.udemy.com/course/spring-framework-5/learn/lecture/8277320?start=39#notes
	* @ModelAttribute
	*/
	@ModelAttribute(name = "MY_PATH")
		public String Dominio_heredarEnTodosLosControllers() {
		return this.DOMINIO;
	}

}
