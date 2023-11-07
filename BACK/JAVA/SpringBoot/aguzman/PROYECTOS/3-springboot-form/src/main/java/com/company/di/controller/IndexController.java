package com.company.di.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


@Controller
public class IndexController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;
	
	@Value(value = "${variableConcatenada}") private String CONCATENADA;

	@GetMapping(path = {"", "/", "index"})
	public String index(Model model) {
		LOG.info("MY_PATH="+DOMINIO);
		/*
		 * USADA PARA EL TEMPLATE DE RUTA "startbootstrap_simple-sidebar.html", PERO:
		 * 	-  DEBE IMPORTARSE EN LOS DEMAS METODOS CONTROLADORES
		 * 	   PORQUE ES LA QUE MUESTRA EL REDIRECCIONAMIENTO DE VOLVER AL INDEX PRINCIPAL , DE LA PLANTILLA
		 * 			/2-springboot-di/src/main/resources/templates/index.html    
		 * 			a-->  /2-springboot-di/src/main/resources/templates/plantilla/startbootstrap_simple-sidebar.html
		 */
		/*FORMA-1*/
//		model.addAttribute("MY_PATH", DOMINIO);
		return "index";
	}
	
	@GetMapping(path = {"/paginaNueva"})
	public String nuevaPagina(Model model) {
		/*FORMA-1*/
//		model.addAttribute("MY_PATH", DOMINIO); // IMPORTACION OBLIGATORIA Y HEREDADA DE  [index(): localhost:8080/index]
		return "otraPagina";
	}

	
	//////////////////////////////////////////////////////////////////////
	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/8277320?start=39#notes
	 * @ModelAttribute
	 */
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		/*FORMA-2*/
		return this.DOMINIO;
	}

}
