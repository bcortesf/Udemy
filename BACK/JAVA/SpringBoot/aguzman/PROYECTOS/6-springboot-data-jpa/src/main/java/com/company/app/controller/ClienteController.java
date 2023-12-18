package com.company.app.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.company.app.controller.entradaDTO.FormData;
import com.company.app.domainEntityPojo.Cliente;
import com.company.app.repositoryDao.IClienteDao;

@Controller
public class ClienteController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	  private IClienteDao clienteDao;

	@GetMapping(path = {"/listar"})
	public String listarC(Model model) {
		LOG.info("Clientes Listados");
		/////////////////////////////////////////////////////////
		//                   PRUEBAS
		model.addAttribute("tituloCliente", "Datos del cliente :D");
		/////////////////////////////////////////////////////////


		model.addAttribute("cliente", null);
		return "cliente/clientes";//HTML
	}


	@GetMapping(path = {"/encontrar/{idUsuario}"})
	public String encontrarC(@PathVariable(name = "idUsuario") Integer idUsuario, Model model) {
		LOG.info("Encontrar cliente por ID<".concat(String.valueOf(idUsuario)).concat(">") );

		Optional<Cliente> opClienteFind = clienteDao.findById(idUsuario);
		LOG.info("cliente: " + opClienteFind);
		if (opClienteFind.isPresent()) {
			LOG.info("->cliente presente");
			model.addAttribute("cliente", opClienteFind.get().toString());
			model.addAttribute("mensajeClienteBuscado", "Cliente encontrado");
		} else {
			LOG.info("->cliente no existe");
			model.addAttribute("cliente", null);
			model.addAttribute("mensajeClienteBuscado", "El cliente no existe");
		}
		return "cliente/clientes";//HTML
	}


//	@PostMapping(path = {"/encontrar/{idUsuario}"})
//	public String encontrarC(@PathVariable(name = "idUsuario") String idUsuario, Model model) {
//		LOG.info("Encontrar cliente por ID<".concat(idUsuario).concat(">") );
//
//		Optional<Cliente> opClienteFind = clienteDao.findById( Integer.parseInt(idUsuario) );
//		LOG.info("cliente: " + opClienteFind);
//		if (opClienteFind.isPresent()) {
//			LOG.info("->cliente presente");
//			model.addAttribute("cliente", opClienteFind.get().toString());
//			model.addAttribute("mensajeClienteBuscado", "Cliente encontrado");
//		} else {
//			LOG.info("->cliente no existe");
//			model.addAttribute("cliente", null);
//			model.addAttribute("mensajeClienteBuscado", "El cliente no existe");
//		}
//		return "cliente/clientes";//HTML
//	}
	
//	@PostMapping(path = {"/encontrar"})
//	public String encontrarC(FormData formData, Model model) {}


	@PostMapping(path = {"/crear"})
	public String crearC(Model model) {
		LOG.info("Cliente Creado");
		return "cliente/clientes";//HTML
	}

	@PutMapping(path = {"/editar"})
	public String editarC(Model model) {
		LOG.info("Cliente Editado");
		return "cliente/clientes";//HTML
	}

	@DeleteMapping(path = {"/eliminar/{idUsuario}"})
	public String eliminarC(@PathVariable(name = "idUsuario") Long idUsuario, Model model) {
		LOG.info("Cliente Eliminado: ".concat(String.valueOf(idUsuario)));
		return "cliente/clientes";//HTML
	}


	/*********************************************/
	/*********************************************/
	@ModelAttribute(name = "clientesList")
	public List<Cliente> listaClientes(){
		return clienteDao.findAll();
	}

}
