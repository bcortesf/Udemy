package com.company.app.repositoryDao;

import java.util.List;
import java.util.Optional;

import com.company.app.domainEntityPojo.Cliente;

public interface IClienteDao {
	List<Cliente> findAll();
	Optional<Cliente> findById(Integer idUsuario);
	Optional<Cliente> create(Cliente cliente);
	Optional<Cliente> edit(Cliente cliente);
	Optional<Cliente> deleteById(Integer idUsuario);
	
}
