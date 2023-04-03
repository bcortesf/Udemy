package com.empresabcf.sb.web.app.controllers;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * 													PARAMETROS DE CONSULTA 
 * https://es.stackoverflow.com/questions/380131/cual-es-basicamente-la-diferencia-entre-la-anotacion-requestparam-y-pathvari
 * @RequestParam: Capturar los parametros de una url, para filtrar                                     GET /user?id=123
 * @PathVariable    : Dirigir a un componente o un dato especifico, ej: id, cedula                GET /user/123
 * 
 * GET /user/@PathVariable?@RequestParam=true
 * GET /user/123                  ?friends=true
 * GET /user/123?friends=true
 */
@Controller
@RequestMapping(path = "requestParams")
public class EJ_RequestParamController {
	
	/**
	 *	ESTE          :		/spring-boot-web/src/main/resources/templates/params/index.html
	 * POR-HTML: 		/requestParams/mix-params?saludo=Hola%20Bryan&amp;año=2022
	 */
	@GetMapping(path = "/string")
	public String param(
			@RequestParam(name = "param1") String texto1, 				            //nombre-original-parametro:<param1>,  alias:<texto1>
			@RequestParam(name = "param2", 
				defaultValue = "SIN VALOR EL parametro2") String texto2,           //parametro vacio
			@RequestParam(name = "param3", required = true) String texto3, 	// parametro obligatorio
			@RequestParam(name = "param4", required = false) String texto4,// parametro opcional
			@RequestParam(name = "param5", required = false, 
				defaultValue = "ALGUN VALOR param5") String texto5, 		  		// parametro opcional
			@RequestParam String parametro, 													//igual-nombre:(parametro y alias)
			Model model) {
		model.addAttribute("resultado1", "El texto1 enviado es:".concat(texto1));
		model.addAttribute("resultado2", "El texto2 enviado es:".concat(texto2));
		model.addAttribute("resultado3", "El texto3 enviado es:".concat(texto3));
		model.addAttribute("resultado4", texto4);
		model.addAttribute("resultado5", texto5);
		model.addAttribute("resultado6", "El param enviado es:".concat(parametro));
		return "params/ver";//	/spring-boot-web/src/main/resources/templates/params/ver.html
	}
	
	/**
	 *	ESTE          :		/spring-boot-web/src/main/resources/templates/params/index.html
	 * POR-HTML: 		/requestParams/mix-params?saludo=Hola%20Bryan&amp;año=2022
	 */
	@GetMapping(path = "/mix-params")//@RequestParam: forma moderna
	public String param(@RequestParam String paramSaludo, @RequestParam Integer paramAño, Model model) {
		model.addAttribute("resultado3",		"El saludo enviado es: '" + paramSaludo + "' en el año: " + paramAño);
		return "params/ver";//	/spring-boot-web/src/main/resources/templates/params/ver.html
	}
	@GetMapping(path = "/mix-params-request")
	public String param(HttpServletRequest request, Model model) {//HttpServletRequest: forma antigua, sin decorador, manejar excepciones
		String saludo = request.getParameter("saludo");
		Integer año   = null;
		try {
			año   = Integer.parseInt( request.getParameter("año") );
		} catch (NumberFormatException e) {
			año = 0;
		}
		model.addAttribute("resultado3",		"El saludo enviado es: '" + saludo + "' en el año: " + año);
		return "params/ver";//	/spring-boot-web/src/main/resources/templates/params/ver.html
	}


	//////////////////////////////////
	@GetMapping(path = "/index")
	public String index() {
		return "params/index";//	/spring-boot-web/src/main/resources/templates/params/index.html
	}
	////////////////////////////////
}
