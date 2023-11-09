package com.company.di.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.company.di.domainEntityPojo.Usuario;
import com.company.di.validation.UsuarioValidador;

import jakarta.validation.Valid;


@Controller	
public class FormularioValidationController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@Autowired private Usuario usuarioDTO;
    @Autowired private UsuarioValidador validadorUsusario;//implementado:    @PostMapping(path = "/form_entidadUsuario_conObjectThymeleaf") procesarFormulario_porDominioUsuario_conObjectThymeleaf
	

	@GetMapping(path = {"/form2"})
	public String verFormulario(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "formulario/llenar2";//	/3-springboot-form/src/main/resources/templates/formulario/llenar2.html
	}

	

	@	PostMapping(path = "/form_entidadUsuario_valida1")
	public String procesarFormulario_porDominioUsuario_valida1(
			@Valid Usuario usuario,
			BindingResult result,
			Model model
	) {  
		
		//PASO1: Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario> debemos mirar la validacion con:
		if (result.hasErrors()) {
			/** 
			 * De forma AUTOMATICO, pasa el objeto<USUARIO> a la vista  "llenar.HTML";      {@ModelAttribute(name = "usuario") } = {model.addAttribute("usuario", usuario);}
			 **/ 
			//model.addAttribute("usuario", usuario);  /* *AUTOMATICO* */
			return "formulario/llenar2";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}
		
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario", usuario);
		return "formulario/verResultado2";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html	
	}
	


	//*********************************************
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		/*FORMA-2*/
		return this.DOMINIO;
	}
	//********************************************
}
