package com.company.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

	// http://localhost:8080/prueba
	// http://localhost:8080/prueba?name=BryanCFz
	@GetMapping("/prueba")
	public String prueba(@RequestParam(name="name", required=false, defaultValue="World") 
			String name, Model model) {
		model.addAttribute("name", name);
		return "prueba";
	}
	// http://localhost:8080/greeting
	// http://localhost:8080/greeting?name=BryanCFz
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World2") 
			String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

}
