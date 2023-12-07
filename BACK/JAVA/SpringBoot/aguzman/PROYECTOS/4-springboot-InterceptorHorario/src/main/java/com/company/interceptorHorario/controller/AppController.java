package com.company.interceptorHorario.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@Value(value = "${config.horario.apertura}") private int horarioApertura;
	@Value(value = "${config.horario.cierre}") private int horarioCierre;


	@GetMapping(path = {"/horarioAbierto"})
	public String laboral(Model model) {
		model.addAttribute("title", "Bienvenido al horario de atención a clientes");
		return "horario/horarioLaboral";//HTML
	}
	
	@GetMapping(path = {"/horarioCerrado"})
	public String descanso(Model model) {
		model.addAttribute("title", "Fuera del horario de atención");
		StringBuilder mensajeCerrado = new StringBuilder();
		mensajeCerrado.append("Fuera del horario de atención");
		mensajeCerrado.append("Apertura: ");
		mensajeCerrado.append(horarioApertura);
		mensajeCerrado.append(", Cierre ");
		mensajeCerrado.append(horarioCierre);
		
		model.addAttribute("mensajeCerrado", mensajeCerrado.toString());
		return "horario/horarioDescanso";//HTML
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
