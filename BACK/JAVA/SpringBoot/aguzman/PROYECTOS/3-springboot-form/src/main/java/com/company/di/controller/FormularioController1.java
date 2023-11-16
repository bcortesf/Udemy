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

import com.company.di.domainEntityPojo.Usuario1;
import com.company.di.validation.UsuarioValidador1;

import jakarta.validation.Valid;

/**
 * @SessionAttributtes   :  Guarda un objeto "modeloEntradaDTO"  en toda la sesionHTTP.
 * 										- Se toma del PostMApping el --> @Valid Usuario <usuario> :
 *     											- @	PostMapping(path = "/form_entidadUsuario")
 *     											- @	PostMapping(path = "/form_entidadUsuario_conObjectThymeleaf")
 * 										- Mismo objeto GetMapping de la:  KEY del modelAttribute ("usuario1", userDTO)  =>   En verFormulario(Model model){...}
 */

@Controller		//@RequestMapping(path = {"/form"})
@SessionAttributes(names = {"usuario1"})
public class FormularioController1 {
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@Autowired private Usuario1 usuarioDTO;
    @Autowired private UsuarioValidador1 validadorUsuario;//implementado:    @PostMapping(path = "/form_entidadUsuario_conObjectThymeleaf") procesarFormulario_porDominioUsuario_conObjectThymeleaf
	

	@GetMapping(path = {"/form"})
	public String verFormulario(Model model) {
		//"usuario1", para que la primera ves que carga la pagina, no lanze NULL-POINTER-EXCEPTION porque no existe objeto usuario en : th:value="${usuario.username}"
		//"usuario1", mismo nombre de @	PostMapping(path = "/form_entidadUsuario")  => @ModelAttribute
		
		Usuario1 usuarioPri = new Usuario1();
		usuarioPri.setPais("Colombia Original");   						//Formulario #3, asociado a un <INPUT>, por ende se puede pasar a otras vistas
		usuarioPri.setIdentificadorUsuario("12345-k"); //identificadorUsuario :NO ESTA MAPEADO, A NINGUN FORMULARIO.POST   ;solo sera visible en "llenar.HTML" -->
		
		model.addAttribute("usuario1", usuarioPri);
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
		
		usuarioDTO.setPais("Colombia copia1");
		//LOG.info("/FORM:  "+ usuarioDTO.toString());
		
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario1", usuarioDTO);
		return "formulario/verResultado";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * "llenar.html"    :Cada atributo HTML.'name' deben llamarse igual al modelo o Dominio<USUARIO>
	 * 
	 * /3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario.java
	 * @Valid                    : Valida cada atributo del modelo ó Dominio<USUARIO>
 	 *                                   - Debe ser el primer atributo, cuando es mi modelo de datos
 	 *                                   - Crea instancia(singleton) y automatico setea modelo ó Dominio<USUARIO>
	 * @ModelAtributte: : Cambiar el nombre de la entidad usuario con un alias diferente en etiqueta {name=".."}
	 *                                   -@ModelAttribute(name = "usuario1"):  sera reconocido en todos los metodos del  "FormularioController"
	 *                                
	 * BindingResult: 
	 * 		- Es el resultado de la validacion @Valid; Contiene los mensajes del error
	 *         - IMPORTANTE  :Debe estar despues de la anotación @Valid
	 */
	@	PostMapping(path = "/form_entidadUsuario")
	public String procesarFormulario_porDominioUsuario(
//			@Valid @ModelAttribute(name = "usuario1") Usuario user,
			@Valid Usuario1 usuario,
			BindingResult result,
			Model model) {

		//LOG.info("/FORM_ENTIDAD-USUARIO:  "+ usuarioDTO.toString());
		usuario.setPais("Suiza");

		// Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario> debemos mirar la validacion con:
		if (result.hasErrors()) {
			Map<String, String> errores = new HashMap<>();
			result.getFieldErrors().forEach( (org.springframework.validation.FieldError err) -> {
				String key = err.getField();
			    String value = "el campo '".concat(err.getField()).concat("' :").concat(err.getDefaultMessage());
				errores.put(key, value);
			});
			//errores.containsKey("username");    errores.get("username");

			/**
			 * De forma AUTOMATICO, pasa el objeto<USUARIO1> a la vista  "llenar.HTML";      {@ModelAttribute(name = "usuario1") } = {model.addAttribute("usuario1", usuario);}
			 *     -Al ser AUTOMATICO despues de enviar la peticion POST;   En la vista "llenar.HTML"   -    se usa  th:value="${usuario.username}", para mantener los valores enviados
			 * */ 
			//model.addAttribute("usuario1", usuario);  /* *AUTOMATICO* */
			
			LOG.info("tenemos-errores");
			LOG.info(errores.toString());
			
			model.addAttribute("errores", errores);
			return "formulario/llenar";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}

		//usuarioDTO = usuario;
		//model.addAttribute("usuario1", user); 			//USADA-POR:   @Valid @ModelAttribute(name = "usuario1") Usuario user,
		
		LOG.info("exitoso");
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario1", usuario);
		return "formulario/verResultado";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html	
	}


	@	PostMapping(path = "/form_entidadUsuario_conObjectThymeleaf")
	public String procesarFormulario_porDominioUsuario_conObjectThymeleaf(
			@Valid Usuario1 usuario,
			BindingResult result,
			Model model,
			SessionStatus status  //limpiar los atributos de sesion guardados en:       @SessionAttributes(names = {"usuario1"}) public class FormularioController{...}
	) {  
		usuario.setPais("China");
		/**
		 * PASO:1.2:  SOLO-SI se implementa una clase validador
		 *                   hacer este paso  1.2,  el cual valida los datos mediante:  /3-springboot-form/src/main/java/com/company/di/validation/UsuarioValidador.java
		 *  
		 *  Solo validamos  <Usuario>.telefono
		 */
		validadorUsuario.validate(usuario, result);
		
		//PASO1: Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario> debemos mirar la validacion con:
		if (result.hasErrors()) {
			LOG.info("tengo-errores");
			LOG.info(result.toString());
//			mostrarErrores(result);

			/** 
			 * De forma AUTOMATICO, pasa el objeto<USUARIO> a la vista  "llenar.HTML";      {@ModelAttribute(name = "usuario1") } = {model.addAttribute("usuario1", usuario);}
			 **/ 
			//model.addAttribute("usuario1", usuario);  /* *AUTOMATICO* */
			return "formulario/llenar";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}
		
		LOG.info("exitoso");
		model.addAttribute("title", "RESULTADO FORM");
		model.addAttribute("usuario1", usuario);
		status.setComplete();
		return "formulario/verResultado";//	/3-springboot-form/src/main/resources/templates/formulario/verResultado.html	
	}
	

	public void mostrarErrores(BindingResult result) {
		result.getFieldErrors().forEach( (org.springframework.validation.FieldError err) -> {
			String key = err.getField();
		    String value = "el campo '".concat(err.getField()).concat("' :").concat(err.getDefaultMessage());
			System.out.println(value);
		});
	}

	//*********************************************
	@ModelAttribute(name = "MY_PATH")
	public String Dominio_heredarEnTodosLosControllers() {
		/*FORMA-2*/
		return this.DOMINIO;
	}
	//********************************************
}
