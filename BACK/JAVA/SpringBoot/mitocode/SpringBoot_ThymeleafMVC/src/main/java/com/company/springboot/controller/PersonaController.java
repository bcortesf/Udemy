package com.company.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.springboot.entityModel.Persona;
import com.company.springboot.repository.IPersonaRepo;

@Controller
public class PersonaController {
	
	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private IPersonaRepo iPersonaRepo;
	
	// http://localhost:8080/save
	//http://localhost:8080/save?name=BryanCFz
		@GetMapping("/save")
		public String save(@RequestParam(name="name", required=false, defaultValue="World") 
				String name, Model model) {

			Persona personaEnti = new Persona();
//			personaEnti.setIdPersona(1); personaEnti.setNombre("Bryan"); //->Ya ejecutado
			personaEnti.setIdPersona(2); personaEnti.setNombre("Nanis");
			iPersonaRepo.save(personaEnti);

			model.addAttribute("name", name);
			return "prueba"; // http://localhost:8080/prueba
		}


		@GetMapping(path  =  "/listar")
//		@GetMapping(path  =  {"/listar"})      //@GetMapping(path  =  {"/listar", "/listarP"})
		public String getPersons(Model model) {
			List<Persona> listaPersonas = iPersonaRepo.findAll();
			LOG.info("" + listaPersonas.toString());
			
			model.addAttribute("personas", listaPersonas);
			return "greeting";
		}

}
