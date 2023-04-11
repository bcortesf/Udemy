package com.empresabcf.sb.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 													VARIABLES DE RUTA
 * https://es.stackoverflow.com/questions/380131/cual-es-basicamente-la-diferencia-entre-la-anotacion-requestparam-y-pathvari
 * @RequestParam: Capturar los parametros de una url, para filtrar                                     GET /user?id=123
 * @PathVariable    : Dirigir a un componente o un dato especifico, ej: id, cedula                GET /user/123
 * 
 * GET /user/@PathVariable?@RequestParam=true
 * GET /user/123                  ?friends=true
 * GET /user/123?friends=true
 */
@Controller
@RequestMapping(path = "/pathVariable")
public class EJ_PathVariableController {

	@GetMapping(path = "/")
	public String index(Model model) {
		model.addAttribute("titulo", "ENVIAR variables de la ruta (@pathVariable)");
		return "variables/index";//		/spring-boot-web/src/main/resources/templates/variables/index.html
	}

//	@GetMapping(path = "/alias-de-variable/{AliasModulo}")
//	public String Variables_con_alias(@PathVariable(name = "AliasModulo") String modulo) {
//		return "";//		
//	}
	
	/**
	 *	ESTE          :		/spring-boot-web/src/main/resources/templates/variables/index.html
	 * POR-HTML: 		http://localhost:8080/pathVariable/string/modulo%20Usuario
	 */
	@GetMapping(path = "/string/{modulo}")
	public String Variables(@PathVariable String modulo, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado1", "Entramos al modulo: ".concat(modulo));
		return "variables/ver";//		/spring-boot-web/src/main/resources/templates/variables/ver.html
	}
	/**
	 *	ESTE          :		/spring-boot-web/src/main/resources/templates/variables/index.html
	 * POR-HTML: 		http://localhost:8080/pathVariable/string/moduloUsuario/1013
	 */
	@GetMapping(path = "/string/{modulo}/{id}")
	public  String Variables(@PathVariable String modulo, @PathVariable Integer id, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado1", "Entramos al modulo: '".concat(modulo) + "',  con la cedula: '".concat(String.valueOf(id)) + "'" );
		return "variables/ver";//		/spring-boot-web/src/main/resources/templates/variables/ver.html
	}
	
}
/**
 *	ESTE          :		/
 * POR-HTML: 		h
 */
/*
 @GetMapping(path = "/xx")
	public String xx() {
		return "";//		
	}
 * */
