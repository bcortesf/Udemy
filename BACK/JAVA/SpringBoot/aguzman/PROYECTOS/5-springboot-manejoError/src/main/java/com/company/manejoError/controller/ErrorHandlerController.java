package com.company.manejoError.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 *@ControllerAdvice: 
 *	- Manejar errores de exepciones presentadas en los controladores que contienen
 *	los endpoints, por ejemplo:
 *		+ NoResourceFoundException, NullPointerException, java.lang.ArithmeticException, ...etc
 *  -Mapea una exepcion que se rpesente en un metodo controllador
 *
 * 
 */
@ControllerAdvice
public class ErrorHandlerController {
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	@ExceptionHandler(value = {ArithmeticException.class})
	public String AritmeticoError(Exception ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());
		
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}

	@ExceptionHandler(value = {NumberFormatException.class})
	public String FormatoNumericoError(Exception ex, Model model) {
		model.addAttribute("error", "Error de formato numérico inválido!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());
		
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}

}
