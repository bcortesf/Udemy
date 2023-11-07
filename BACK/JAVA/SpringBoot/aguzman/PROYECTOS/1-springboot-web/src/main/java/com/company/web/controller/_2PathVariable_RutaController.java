package com.company.web.controller;

import org.springframework.beans.factory.annotation.Value;
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
public class _2PathVariable_RutaController {
	@Value(value= "${protocolo.dominio.puerto}") private String RUTA_PROYECTO;
	/////////////////////////////////////////////////////////////
	@GetMapping(path = "/")
	public String index(Model model) {
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "2PathVariable_variable/indexPathVariable";//	/1-springboot-web/src/main/resources/templates/2PathVariable_variable/indexPathVariable.html
	}
	/////////////////////////////////////////////////////////////

	/**                                  /alias-variable/{AliasModulo}
	 * END-POINT    :		../pathVariable/string/{modulo}
	 * REDIRECT-TO:		http://localhost:8080/pathVariable/string/modulo%20Usuario
	 */
	@GetMapping(path = "/string/{modulo}")
	public String variable(@PathVariable String modulo, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado1", "Entramos al modulo: ".concat(modulo));
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "2PathVariable_variable/ver";//	/1-springboot-web/src/main/resources/templates/2PathVariable_variable/ver.html
	}
	/**                                  /alias-variable/{AliasModulo}/{AliasId}
	 * END-POINT    :		../pathVariable/string/{modulo}/{id}
	 * REDIRECT-TO:		http://localhost:8080/pathVariable/string/moduloUsuario/1013
	 */
	@GetMapping(path = "/string/{modulo}/{id}")
	public String variable(@PathVariable(name = "modulo") String aliasModulo, @PathVariable Integer id, Model model) {
		model.addAttribute("titulo", "Recibir variables de la ruta (@PathVariable)");
		model.addAttribute("resultado1", "Entramos al modulo: '".concat(aliasModulo) + "',  con la cedula: '".concat(String.valueOf(id)) + "'" );
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "2PathVariable_variable/ver";//	/1-springboot-web/src/main/resources/templates/2PathVariable_variable/ver.html
	}

}


















