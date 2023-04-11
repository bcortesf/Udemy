package com.empresabcf.sb.form.app.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.empresabcf.sb.form.app.models.domain.Usuario;

import jakarta.validation.Valid;
//import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//@RequestMapping(path = {"/frm"})
public class FormularioController {
	@Autowired
	private Usuario usuario;

	/*
	 * http://localhost:8080/frm
	 * siempre ejecuta el GET, pero el POST no lo renderiza en una URL nunca, ""OJO""
	 */
	@GetMapping(path = {"/frm"}) //path: String[] = {""}
	public String VerLLenar_Formulario(Model model) {
		model.addAttribute("titulo", "FORMULARIO USUARIOS");
		model.addAttribute("usuario", new Usuario());
		return "form/get_ingresarForm";//	/3-spring-boot-form/src/main/resources/templates/form/get_ingresarForm.html
	}
	
	@PostMapping(path = {"/frm"})
	public String procesarFormulario_porAtributos(Model model
			,@RequestParam(name  = "username_getForm") String username	   //get_ingresarForm.html -> ASIGNAR-ALIAS-A: name="username_getForm"
			,@RequestParam                             String password2023 //get_ingresarForm.html -> sino tiene alias MISMO-NOMBRE: name="password2023"  
			,@RequestParam                             String email2023) {
		usuario.setUsername(username);
		usuario.setPassword(password2023);
		usuario.setEmail(email2023);
		model.addAttribute("titulo", "RESULTADO FORM");
		model.addAttribute("uusername", usuario.getUsername());
		model.addAttribute("usuario", usuario);
		return "form/post_resultadoForm";//	/3-spring-boot-form/src/main/resources/templates/form/post_resultadoForm.html
	}
	@PostMapping(path = {"/frm_objetoUsuario"})
	public String procesarFormulario_porObjUsuario(
			/**
			 * "get_ingresarForm.html" cada atributo <name="atr"> ==> debe llamarse igual al modelo<USUARIO>
			 * DEBE SER EL PRIMER ATRIBUTO, AL SER UN OBJETO
			 * 
			 * /3-spring-boot-form/src/main/java/com/empresabcf/sb/form/app/models/domain/Usuario.java
			 * @Valid         : valida cada campo del objeto <Usuario>
			 * @ModelAtributte: crea instancia automatica y hace un set al Usuario, por singleton 
			 * BindingResult: 
			 * 		- Debe estar despues del objeto que se valida, @Valid
			 * 		- representa el resultado de la validacion, contiene los mensajes del error
			 */
			@Valid @ModelAttribute("usuario") Usuario usuario,
			BindingResult result,
			Model model) {
		
		model.addAttribute("titulo", "RESULTADO FORM2");
		// Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario> debemos mirar la validacion con:
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<String, String>();
			result.getFieldErrors().forEach(err -> {
				errores.put(err.getField(), 
						"el campo '".concat(err.getField()).concat("' ")
						.concat(err.getDefaultMessage())
				);
			});
			model.addAttribute("errores", errores);
			return "form/get_ingresarForm";
		}		
		model.addAttribute("uusername", usuario.getUsername());
		model.addAttribute("usuario", usuario);
		return "form/post_resultadoForm";//	/3-spring-boot-form/src/main/resources/templates/form/post_resultadoForm.html
	}
}
