package com.company.di.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.company.di.domainEntityPojo.Ciudad;

@Repository
public class CiudadRepository {
	private final List<Ciudad> ciudades;
	
	public CiudadRepository() {
		this.ciudades = Arrays.asList(
				new Ciudad(1, "BTA", "Bogotá"),			new Ciudad(2, "CLI", "Cali"), 		new Ciudad(3, "MIN", "Medellin")
		); 
	}

	public List<Ciudad> getCiudades() {
		return ciudades;
	}

}
