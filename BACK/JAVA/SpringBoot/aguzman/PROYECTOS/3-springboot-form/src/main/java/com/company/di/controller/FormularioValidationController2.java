package com.company.di.controller;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.company.di.commons.editors.NombreMayusculaEditor;
import com.company.di.domainEntityPojo.Pais;
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

		//-------------------------------------------------------------------------------------------------------------------------------------
															/*EDITOR-PROPIEDAD-DE-SPRING*/
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false); //ESTRICTO, para que no cambie un dia o un mes o un  añó. En la fecha

		/** CAMPO ESPECIFICO:		/3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario2.java*/
		binder.registerCustomEditor(Date.class, "fechaNac3",  new CustomDateEditor(dateFormat, true));
		
		/**TODOS LOS CAMPOS FECHA, PERO
		 * 1. FORMULARIO.HTML:   los input deben ser de tipo Date
		 * 2. USUARIO2.JAVA        :   todos los atributos fecha deben ser de la clase <javaUtilDate>
		 * */
		//binder.registerCustomEditor(Date.class,  new CustomDateEditor(dateFormat, false));
		
		//-------------------------------------------------------------------------------------------------------------------------------------
															/*EDITOR-PROPIEDAD-PERSONALIZADO-CUSTOM*/
		/** CAMPO ESPECIFICO:		/3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario2.java*/
		binder.registerCustomEditor(String.class, "nombre", new NombreMayusculaEditor());
	}


	@GetMapping(path = {"/form2"})
	public String verFormulario(Model model) {
		model.addAttribute("usuario", new Usuario2());

//		Usuario2 usuario2 = new Usuario2();
//		usuario2.setPais("Colombia");
//		model.addAttribute("usuario", usuario2);

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
		 * En caso contrario, no ejecuta nada de <PASO2> 		procesarFormulario_porDominioUsuario_valida1(){...}
		 */
		LOG.info(usuario2.toString());
		
		//PASO2: Antes de procesar, guardar en bd o pasar a la vista el objeto<Usuario2> debemos mirar la validacion con:
		if (result.hasErrors()) {
			/** 
			 * De forma AUTOMATICO, pasa el objeto<Usuario2> a la vista  "llenar.HTML";      {@ModelAttribute(name = "usuario") } = {model.addAttribute("usuario", usuario);}
			 **/ 
			//model.addAttribute("usuario", usuario2);  /* *AUTOMATICO* */
			
			LOG.info("tenemos-errores");
			LOG.info("RESULTADO-DE-MIS-ERRORES:  " + result.toString());
			return "formulario/llenar2";//	/3-springboot-form/src/main/resources/templates/formulario/llenar.html
		}
		
		LOG.info("exito");
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
	
	@ModelAttribute(name = "paisesStrList")
	public List<String> getPaisesStrings() {
		return Arrays.asList("España", "México", "Chile", "Argentina", "Perú", "Colombia", "Venezuela", "China","Suizaaa");
	}
	@ModelAttribute(name = "paisesObjList")
	public List<Pais> getPaisesObjetos() {
		Pais pais1 = new Pais(1, "ES", "España");			Pais pais2 = new Pais(2, "MX", "México"); 		Pais pais3 = new Pais(3, "CL", "Chile"); 
		Pais pais4 = new Pais(4, "AR", "Argentina"); 		Pais pais5 = new Pais(5, "PR", "Perú"); 				Pais pais6 = new Pais(6, "CO", "Colombia");
		Pais pais7 = new Pais(7, "VE", "Venezuela"); 	Pais pais8 = new Pais(8, "CH", "China"); 			Pais pais9 = new Pais(9, "SZ", "Suizaaa"); 
		return Arrays.asList(pais1, pais2, pais3, pais4, pais5, pais6, pais7, pais8, pais9);
	}
	//********************************************
}
