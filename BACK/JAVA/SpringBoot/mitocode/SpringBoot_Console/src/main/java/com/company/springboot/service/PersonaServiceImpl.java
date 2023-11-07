package com.company.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.springboot.entity.Persona;
import com.company.springboot.repository.IPersonaRepo;
//import com.company.springboot.repository.PersonaRepoImpl;

/**
 * @Service: Capa que maneja la logica del negocio, condicionales, seteos, operaciones y validaciones
 * @Qualifier : cuando se tienen (2 mas clases-concretas)
 */


@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired		//:busca la instancia que tiene su siguiente capa: "PersonaRepoImpl", por el stereotipo @Repository ~~ equivalente al  "->JAVA-PURO"
	@Qualifier(value = "personaRepoImpl1")   //:mismo nombre del @Service @Qualifier(name)
	//@Qualifier(value = "PPersonaRepoImpl2")   //:mismo nombre del @Service(name)
	//@Qualifier(value = "personaRepoImpl3")   //:si tiene un stereotipo sin propiedades en el encabezado de la clase.   Poner clase con PRIMER-LETRA-MINUSCULA
	private IPersonaRepo iPersonaRepo;

	@Override
	public void registrar(Persona persona) {
		//iPersonaRepo = new PersonaRepoImpl();   /*->JAVA-PURO*/
		iPersonaRepo.registrar(persona);
	}

}
