package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.entityBeans.Jugador;
import com.company.repositoryDao.DAOJugador;

@Service
public class ServiceJugadorImpl implements IServiceJugador {
	
	@Autowired
	private DAOJugador daoJugador;

	@Override
	public void registrar(Jugador jugador) throws Exception {
		try {
			daoJugador.registrar(jugador);
		} catch (Exception e) {
			throw e;
		}
	}

}
