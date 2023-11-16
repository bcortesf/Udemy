package com.company.di.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.di.domainEntityPojo.Usuario2;
import com.company.di.validation.UsuarioValidador2;

import jakarta.validation.Valid;


@Controller	
public class FormularioValidationController2 {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;
	
	@Autowired private UsuarioValidador2 validadorUsuario;
	
	/**
	 * @InitBinder	:es un tipo de interceptor que se ejecuta antes de la llamada a los métodos del controlador donde se valida
                                 -se usa para configurar y registrar nuestros validadores,reglas y conversiones.
                                 		-Antes de poblar los datos
                                 		-Antes de hacer la peticion HTTP que llama al metodo
                                 				 @PostMappig public String procesarFormulario_porDominioUsuario_valida1(){...}
	 */
	@InitBinder
	public void initBinder_validaAntesDePoblarUsuario(WebDataBinder binder) {
		/**REEMPLAZA-Y-BORRA las @anotaciones<Usuario2> y  SOLO-DEJA-VALIDACION <Usuario2>.telefono*/
		//binder.setValidator(validadorUsuario); 
		
		/**DEJA-TODAS las @anotaciones con sus validaciones y  AGREGA-VALIDACION <Usuario2>.telefono*/
		binder.addValidators(validadorUsuario);
	}


	@GetMapping(path = {"/form2"})
	public String verFormulario(Model model) {
		model.addAttribute("usuario", new Usuario2());
		return "formulario/llenar2";//	/3-springboot-form/src/main/resources/templates/formulario/llenar2.html
	}

	/**
	 * @param : @Valid usuario
	 * 				- llama al metodo @InitBinder initBinder_validaAntesDePoblarUsuario(WebDataBinder binder) {...}
	 */
	@	PostMapping(path = "/form_entidadUsuario_valida1")
	public String procesarFormulario_porDominioUsuario_valida1(
			@Valid @ModelAttribute(name = "usuario") Usuario2 usuario2,  /**@ModelAttribute(name = "usuario") Usuario usuario*/
			BindingResult result,
			Model model
	) {  
		/**
		 * PASO1:
		    		Por el @Valid, debe validar primero el metodo de inicializacion:  initBinder_validaAntesDePoblarUsuario(){..}
		 * Si todo sale exitoso , ejecuta toda la logica de este metodo @PostMapping
		 * En caso contrario, no ejecuta nada de 		procesarFormulario_porDominioUsuario_valida1(){...}
		 */
		
		//PASO2: Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario2> debemos mirar la validacion con:
		if (result.hasErrors()) {
			/** 
			 * De forma AUTOMATICO, pasa el objeto<Usuario2> a la vista  "llenar.HTML";      {@ModelAttribute(name = "usuario") } = {model.addAttribute("usuario", usuario);}
			 **/ 
			//model.addAttribute("usuario", usuario);  /* *AUTOMATICO* */
			return "formulario/llenar2";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}
		
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario", usuario2);
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
