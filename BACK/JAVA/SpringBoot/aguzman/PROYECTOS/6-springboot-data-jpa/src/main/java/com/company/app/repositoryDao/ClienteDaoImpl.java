package com.company.app.repositoryDao;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.company.app.domainEntityPojo.Cliente;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ClienteDaoImpl implements ICliente {
	///////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("unused")
	private void metodosCrud() {
		//ALGUNOS METODOS PARA PERSISTIR A LA BASE DE DATOS
		em.persist(em);		em.remove(em);		em.find(null, em);		em.createNamedQuery(null);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////

	@PersistenceContext
	  private EntityManager em;


	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true) //Para todas operaciones CRUD. Para consultas, siempre es TRUE "solo-lectura"
	@Override
	public List<Cliente> findAll() {
		Cliente cliente = new Cliente((long) 1, "bryan", "cort", "bcortesf.developer@gmail.com", new Date(2023, 2, 3));
		return Arrays.asList(cliente);
		///6-springboot-data-jpa/src/main/java/com/company/app/domainEntityPojo/Cliente.java
//		return em.createQuery("from Cliente").getResultList();
	}

	@Override
	public Optional<Cliente> findById(Integer idUsuario) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cliente> create(Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cliente> edit(Cliente cliente) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public Optional<Cliente> deleteById(Integer idUsuario) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
