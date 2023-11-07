package com.company.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


/**
 * Enviara un menaje hacia un HTML, que se va a definir
 */
@Controller
public class HomeController {

	/* 
	 * "/" Mapea hacia la raiz`
	 *  Model:  modelo de salida
	 */

	// http://localhost:8080
	// http://localhost:8080/
	@GetMapping("/")
	public String getHome(Model model) {
		model.addAttribute("titulo", "Bienvenido@, página de inicio");
		return "inicioIndex"; // /SpringBoot_ThymeleafMVC/src/main/resources/templates/inicioIndex.html	
	}

}
