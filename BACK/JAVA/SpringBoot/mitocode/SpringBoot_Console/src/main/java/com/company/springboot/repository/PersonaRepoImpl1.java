package com.company.springboot.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.company.springboot.entity.Persona;

/**
 * @Repository:  Capa que controla acceso a  datos,  transacciones , con la base de datos.  CRUD
 */


@Repository
@Qualifier(value = "personaRepoImpl1")
public class PersonaRepoImpl1 implements IPersonaRepo{
	
	private Logger LOG = LoggerFactory.getLogger(PersonaRepoImpl1.class);

	@Override
	public void registrar(Persona persona) {
		LOG.info("1.Se registro a:  " + persona.toString());
	}
	
}
