package com.company.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.springboot.entityModel.Persona;


/**											 	JpaRepository<T, ID>
 * 												JpaRepository<Clase, Clase[ClavePrimaria]>
 * 												JpaRepository<Persona, Persona[idPersona]>  
 */
public interface IPersonaRepo extends JpaRepository<Persona, Integer> {

}
	