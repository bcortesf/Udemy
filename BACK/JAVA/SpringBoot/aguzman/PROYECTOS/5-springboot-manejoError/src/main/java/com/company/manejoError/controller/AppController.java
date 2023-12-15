package com.company.manejoError.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AppController {
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@SuppressWarnings("unused")
	@GetMapping(path = {"/dividir"})//RUTA-MAL-ESCRITA-EN-NAVEGADOR : Error<404>
	public String error500_DIVISION(Model model) {
		model.addAttribute("OK_UNO", "si no presenta error, se muestra contenido en 'paginaPrincipal.HTML' ");
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		/*PRUEBA-1.1	:Error<500> - ARITMETICO POR DIVISION, @ExceptionHandler(value = {ArithmeticException.class})*/
		Integer valor =  100/0;
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		return "paginaPrincipal";//HTML :si  todo sale exitoso y sin errores
	}

	@SuppressWarnings("unused")
	@GetMapping(path = {"/convertir"})//RUTA-MAL-ESCRITA-EN-NAVEGADOR : Error<404>
	public String error500_CONVERTIR(Model model) {
		model.addAttribute("OK_UNO", "si no presenta error, se muestra contenido en 'paginaPrincipal.HTML' ");
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		/*PRUEBA-1.2	:Error<500> - FORMATO NUMERICO       , @ExceptionHandler(value = {NumberFormatException.class})*/
		Integer valor =  Integer.parseInt("34x");
		///////////////////////////////////////////////////////////////////////////////////////////////////////
		return "paginaPrincipal";//HTML :si  todo sale exitoso y sin errores
	}



	//////////////////////////////////////////////////////////////////////
	/**
	* https://www.udemy.com/course/spring-framework-5/learn/lecture/8277320?start=39#notes
	* @ModelAttribute
	*/
	@ModelAttribute(name = "MY_PATH")
		public String Dominio_heredarEnTodosLosControllers() {
		return this.DOMINIO;
	}

}
