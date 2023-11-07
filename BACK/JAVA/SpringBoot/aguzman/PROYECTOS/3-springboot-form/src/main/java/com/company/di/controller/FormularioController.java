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

import com.company.di.domainEntityPojo.Usuario;

import jakarta.validation.Valid;

@Controller
//@RequestMapping(path = {"/form"})
public class FormularioController {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@Autowired private Usuario usuarioDTO;


	@GetMapping(path = {"/form"})
	public String verFormulario(Model model) {
		return "formulario/llenar";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
	}
	@	PostMapping(path = "/form")
	public String procesarFormulario_porAtributosNameHTML(Model model
			,@RequestParam String  username
			,@RequestParam(name = "password") String Xpassword
			,@RequestParam(name = "email") String Xemail) {
		usuarioDTO.setUsername(username);
		usuarioDTO.setPassword(Xpassword);
		usuarioDTO.setEmail(Xemail);
		//LOG.info("/FORM:  "+ usuarioDTO.toString());
		
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario", usuarioDTO);
		return "formulario/verResultado";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * "llenar.html"    :Cada atributo HTML.'name' deben llamarse igual al modelo o Dominio<USUARIO>
	 * 
	 * /3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario.java
	 * @Valid                   : valida cada atributo del modelo ó Dominio<USUARIO>
	 * @ModelAtributte: crea instancia(singleton) y automatico setea modelo ó Dominio<USUARIO>
	 *                                 - Debe ser el primer atributo, cuando es mi modelo de datos
	 * BindingResult: 
	 * 		- Es el resultado de la validacion @Valid; Contiene los mensajes del error
	 *         - IMPORTANTE  :Debe estar despues de la anotación @Valid
	 */
	@	PostMapping(path = "/form_entidadUsuario")
	public String procesarFormulario_porDominioUsuario(
			@Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult result,
			Model model) {
		//
		//LOG.info("/FORM_ENTIDAD-USUARIO:  "+ usuarioDTO.toString());

		// Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario> debemos mirar la validacion con:
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach( (org.springframework.validation.FieldError err) -> {
				String key = err.getField();
			    String value = "el campo '".concat(err.getField()).concat("' :").concat(err.getDefaultMessage());
				errores.put(key, value);
			});
			//errores.get("username");

			model.addAttribute("errores", errores);
			return "formulario/llenar";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}

		//LOG.info("no-hay-errores");
		//usuarioDTO = usuario;
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario", usuario);
		return "formulario/verResultado";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html	
	}



	//*********************************************
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		/*FORMA-2*/
		return this.DOMINIO;
	}
	//********************************************
}
