package com.company.di.service;

import java.util.List;
import java.util.Optional;

import com.company.di.domainEntityPojo.Pais;

public interface IPaisService {
	public List<Pais> allPaises();
	public Optional<Pais> findPaisBy(Integer idPais);
}
