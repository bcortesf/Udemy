package com.company.springboot.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.springboot.entity.Persona;

/**
 * @Repository:  Capa que controla acceso a  datos,  transacciones , con la base de datos.  CRUD
 */


@Repository(value = "PPersonaRepoImpl2")
public class PersonaRepoImpl2 implements IPersonaRepo{
	
	private Logger LOG = LoggerFactory.getLogger(PersonaRepoImpl2.class);

	@Override
	public void registrar(Persona persona) {
		LOG.info("2.Se registro a:  " + persona.toString());
	}
	
}
