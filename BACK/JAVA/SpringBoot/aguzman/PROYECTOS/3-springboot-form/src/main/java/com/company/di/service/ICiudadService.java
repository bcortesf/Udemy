package com.company.di.service;

import java.util.List;
import java.util.Optional;

import com.company.di.domainEntityPojo.Ciudad;

public interface ICiudadService {
	public List<Ciudad> allCiudades();
	public Optional<Ciudad> findCiudadBy(Integer idPais);
}
