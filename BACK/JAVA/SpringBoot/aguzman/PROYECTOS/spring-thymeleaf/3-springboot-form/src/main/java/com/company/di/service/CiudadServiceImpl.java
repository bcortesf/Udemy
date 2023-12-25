package com.company.di.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.di.domainEntityPojo.Ciudad;
import com.company.di.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements ICiudadService {
	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
		private CiudadRepository ciudadRepository;


	public CiudadServiceImpl() {
	}


	@Override
	public List<Ciudad> allCiudades() {
		return this.ciudadRepository.getCiudades();
	}

	@Override
	public Optional<Ciudad> findCiudadBy(Integer idCiudad) {
		Optional<Ciudad> ciudad = this.ciudadRepository.getCiudades().stream()
				.filter((Ciudad c) -> c.getId() == idCiudad)
				.findFirst();
		return ciudad;
	}

}
