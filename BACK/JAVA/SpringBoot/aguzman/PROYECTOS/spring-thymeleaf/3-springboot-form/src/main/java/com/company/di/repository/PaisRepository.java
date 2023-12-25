package com.company.di.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.di.domainEntityPojo.Pais;

@Repository
public class PaisRepository {
	private final List<Pais> paises;
	
	public PaisRepository() {
		this.paises = Arrays.asList(
				new Pais(1, "ES", "España"),			new Pais(2, "MX", "México"), 		new Pais(3, "CL", "Chile"),
				new Pais(4, "AR", "Argentina"), 		new Pais(5, "PR", "Perú"), 				new Pais(6, "CO", "Colombia"),
				new Pais(7, "VE", "Venezuela"), 	    new Pais(8, "CH", "China"), 			new Pais(9, "SZ", "Suizaaa")
		); 
	}

	public List<Pais> getPaises() {
		return paises;
	}

}
