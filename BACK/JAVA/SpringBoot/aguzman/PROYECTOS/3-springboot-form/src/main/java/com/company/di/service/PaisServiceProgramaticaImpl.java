package com.company.di.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.di.domainEntityPojo.Pais;
import com.company.di.repository.PaisRepository;

@Service
public class PaisServiceProgramaticaImpl implements IPaisService {
	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
		private PaisRepository paisRepository;


	public PaisServiceProgramaticaImpl() {
	}


	@Override
	public List<Pais> allPaises() {
		return this.paisRepository.getPaises();
	}

	@Override
	public Optional<Pais> findPaisBy(Integer idPais) {
		//LOG.info("inicia busquedad por ID=" + idPais);
		Optional<Pais> pais = this.paisRepository.getPaises().stream()
				.filter(t -> t.getId() == idPais)
				.findFirst();
		//LOG.info("resultado OBJ.paisById:  " + pais);
		return pais;
	}


    //----------------------------------------------------------------
	@SuppressWarnings("unused")
	private Pais obtenerPorId(Integer id) {
		Pais paisEncontrado = null;
		for (Pais pais : this.paisRepository.getPaises()) {
			if (pais.getId() == id) {
				paisEncontrado = pais;
				break;
			}
		}
		return paisEncontrado;
	}
	//----------------------------------------------------------------
}
