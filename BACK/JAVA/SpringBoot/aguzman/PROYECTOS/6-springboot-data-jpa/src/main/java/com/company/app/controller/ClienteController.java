package com.company.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.app.domainEntityPojo.Cliente;
import com.company.app.repositoryDao.ICliente;

@Controller
public class ClienteController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	  private ICliente cliente;

	@GetMapping(path = {"/listar"})
	public String listarC(Model model) {
		return "cliente/clientes";//HTML
	}

	@DeleteMapping(path = {"/encontrar"})
	public String encontrarC(Model model) {
		LOG.info("Cliente Encontrado");
		return "cliente/clientes";//HTML
	}

	@DeleteMapping(path = {"/crear"})
	public String crearC(Model model) {
		LOG.info("Cliente Creado");
		return "cliente/clientes";//HTML
	}

	@PostMapping(path = {"/editar"})
	public String editarC(Model model) {
		LOG.info("Cliente Editado");
		return "cliente/clientes";//HTML
	}

	@DeleteMapping(path = {"/eliminar"})
	public String eliminarC(Model model) {
		LOG.info("Cliente Eliminado");
		return "cliente/clientes";//HTML
	}


	/*********************************************/
	/*********************************************/
	@ModelAttribute(name = "clientesList")
	public List<Cliente> listaClientes(){
		return cliente.findAll();
	}

}
