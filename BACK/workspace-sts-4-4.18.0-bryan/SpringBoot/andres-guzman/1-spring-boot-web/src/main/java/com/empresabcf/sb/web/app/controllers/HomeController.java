package com.empresabcf.sb.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/** 
 * spring lo hace con forward para el Dispatcher y redirect para sendRedirect.
   La diferencia es que forward redirige a otro recurso o ruta pero dentro del mismo request, 
   sin recargar la página, sin iniciar una nueva petición http
 
 * Mientras que redirect redirige a una página o ruta iniciando una nueva petición http, 
   por lo tanto todos los datos que teníamos en el request como parámetros y atributos se pierden 
   ya que se reinicia la petición.

 * -------------------------------------------------------------
 * PARA PRUEBAS: DESCOMENTAR UN METODO Y COMENTAR EL OTRO METODO
 * Ingresando al dominio
	 * 		http://localhost:8080
	 * 		http://localhost:8080/
 */
@Controller
public class HomeController {
	
	/** 
	 * "redirect": recarga la pagina, REINICIA EL REQUEST, PETICION NUEVA
	 * /spring-boot-web/src/main/java/com/empresabcf/sb/web/app/controllers/IndexController.java
	 */
	@GetMapping(path = {"/"}) //-> "/": se va a la raiz de nuestro proyecto 
	public String redirectHome() {
		return "redirect:/app/index";
	}


	/** 
	 * "forward": mantiene envio de (PARAMETROS, ATRIBUTOS), MISMO REQUEST Y PETICION, no cambia la ruta URL, es estatica
	 * /spring-boot-web/src/main/java/com/empresabcf/sb/web/app/controllers/IndexController.java
	 */
//	@GetMapping(path = {"/"}) //-> "/": se va a la raiz de nuestro proyecto 
//	public String forwardHome() {
//		return "forward:/app/index";
//	}
}
/*
@GetMapping(path = {"/"}) 
public String redirectHome() {
	return "redirect:https://www.youtube.com/";
}
*/