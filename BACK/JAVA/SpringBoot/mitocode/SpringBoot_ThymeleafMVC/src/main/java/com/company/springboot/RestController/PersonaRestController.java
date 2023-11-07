package com.company.springboot.RestController;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springboot.entityModel.Persona;
import com.company.springboot.repository.IPersonaRepo;

@RestController
@RequestMapping(path = "/persona_rest")
public class PersonaRestController {
	
	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	private IPersonaRepo iPersonaRepo;
	

		@GetMapping(path  =  "/list")
//		@GetMapping(path  =  {"/listar2"})      //@GetMapping(path  =  {"/listar2", "/listar2"})
		public List<Persona> persons() {
			List<Persona> listaPersonas = iPersonaRepo.findAll();
			LOG.info("list:  " + listaPersonas.toString());

			return listaPersonas;
		}
		

		@GetMapping(path  =  "/get/{personaId}")
		public Optional<Persona> person(@PathVariable(name = "personaId") int idPersona) {
			Optional<Persona> optPersonaExistente = iPersonaRepo.findById(idPersona);
			LOG.info("getPersona:  " + optPersonaExistente.toString());
			return optPersonaExistente;
		}
		
		@PostMapping(path = "save")
		public Optional<Persona> save(@RequestBody Persona personaEnti) {
//			Persona personaEnti = new Persona();
//			personaEnti.setIdPersona(1); personaEnti.setNombre("Bryan"); //->Ya ejecutado
//			personaEnti.setIdPersona(2); personaEnti.setNombre("Nanis"); //->Ya ejecutado
			
			Optional<Persona> optPersona =  this.person(personaEnti.getIdPersona());
			if (optPersona.isEmpty() ) {
				Persona personaSave = iPersonaRepo.save(personaEnti);
				LOG.info("save:  " + personaSave);
				return Optional.of(personaSave);
			}
			LOG.info("PERSONA EXISTENTE CON ID[" + optPersona.get() .getIdPersona()+ "]");
			return optPersona;
		}
		
		@PutMapping(path = "update/{personaId}")
		public Optional<Persona> update(@PathVariable(name = "personaId") int personaId, @RequestBody Persona personaActualizada) {
			Optional<Persona> optPersonaExistente = this.person(personaId);
			if (optPersonaExistente.isPresent()) {
				optPersonaExistente.get().setNombre(personaActualizada.getNombre());
				LOG.info("update:  " + optPersonaExistente.get());
				iPersonaRepo.save(optPersonaExistente.get()); //toma el idPersona en BD; si existe actualiza, sino existe  lo inserta nuevo
			}
			return null;
		}
		
		@DeleteMapping(path = "delete/{personaId}")
		public boolean delete(@PathVariable(name = "personaId") int personaId) {
			Optional<Persona> optPersonaExistente = this.person(personaId);
			if (optPersonaExistente.isPresent()) {
				iPersonaRepo.deleteById(personaId);
				LOG.info("delete:  " + "persona eliminada con ID[" + personaId + "]");
				return true;
			}
			return false;
		}

}
