package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entityBeans.Marca;
import com.company.repositoryDao.DAOMarca;

@Service
public class ServiceMarcaImpl implements IServiceMarca {
	
	@Autowired
	private DAOMarca daoMarca;

	@Override
	public void registrar(Marca marca) throws Exception {
		try {
			daoMarca.registrar(marca);
//			daoMarca.registrar_incrementID(marca);
		} catch (Exception e) {
			throw e;
		}
	}

}
