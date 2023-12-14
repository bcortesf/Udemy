package com.company.manejoError.controller;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.company.manejoError.Exceptions.UsuarioNoEncontradoException;
import com.company.manejoError.Exceptions.UsuarioNoEncontradoRuntimeException;

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
	Logger LOG = LoggerFactory.getLogger(getClass());
	@Value(value = "${controller.index.index.dominio}") private String DOMINIO;

	/*
	 * :Error<500> - ARITMETICO POR DIVISION
	 */
	@ExceptionHandler(value = {ArithmeticException.class})
	public String AritmeticoError(Exception ex, Model model) {
		model.addAttribute("error", "Error de aritmética");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());
		
		model.addAttribute("ERROR_UNO", "Tengo problemas de matématicas en la división ");
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}
	/*
	 * :Error<500> - FORMATO NUMERICO
	 */
	@ExceptionHandler(value = {NumberFormatException.class})
	public String FormatoNumericoError(Exception ex, Model model) {
		model.addAttribute("error", "Error de formato numérico inválido!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());

		model.addAttribute("ERROR_UNO", "Tengo problemas, porque no puedo convertir letras en numeros");
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*
	 * :Error<500> - USUARIO NO ENCONTRADO POR ID - EXEPTION
	 */
	@ExceptionHandler(value = {UsuarioNoEncontradoException.class})
	public String NoExisteElementoError(UsuarioNoEncontradoException ex, Model model) {
		model.addAttribute("error", "Error de elemento no encontrado!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.NOT_FOUND.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());

		model.addAttribute(
				"ERROR_UNO"
				, "Tengo problemas, porque no puedo encontrar el usuario por ID:".concat(ex.getIdUsuario().toString())
		);
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}
	/*
	 * :Error<500> - USUARIO NO ENCONTRADO POR ID - RUNTIME-EXEPTION
	 */
	@ExceptionHandler(value = {UsuarioNoEncontradoRuntimeException.class})
	public String NoExisteElementoError(UsuarioNoEncontradoRuntimeException ex, Model model) {
		model.addAttribute("error", "Error de USUARIO no encontrado!");
		model.addAttribute("message", ex.getMessage());
		model.addAttribute("status", HttpStatus.NOT_FOUND.value()); //<Error-500>
		model.addAttribute("timestamp", new Date());

		model.addAttribute(
				"ERROR_UNO"
				, "Tengo problemas, porque no puedo encontrar el usuario por ID:".concat(ex.getIdUsuario().toString())
		);
		model.addAttribute("MY_PATH", DOMINIO);
		return "error/Aritmetico";//HTML: /5-springboot-manejoError/src/main/resources/templates/error/Aritmetico.html
	}

}
