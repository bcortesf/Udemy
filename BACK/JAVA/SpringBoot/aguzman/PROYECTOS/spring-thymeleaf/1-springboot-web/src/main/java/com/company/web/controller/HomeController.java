package com.company.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <SPRING>    :lo hace con <forward> para el <Dispatcher>
 * <JAVA>       :lo hace con <redirect> para el <sendRedirect>
 * 
 * 
 * <forward> MISMO REQUEST Y PETICION,   NO CAMBIA RUTA URL,   ES ESTATICA (solo rutas de @Controllers de spring)
 *                   redirige a otro recurso o ruta pero dentro del mismo request , 
 *                   sin recargar la página, sin iniciar una nueva petición http
 * 
 * <redirect> REINICIA EL REQUEST, PETICION NUEVA
 *                  recarga a una página o ruta iniciando una NUEVA-PETICION HTTP, 
 *                  por lo tanto todos los datos que teníamos en el request como:
 *                    - (parámetros y atributos) se pierden ya que se reinicia la petición
 */
@Controller
public class HomeController {

	/**
	 * END-POINT    :		http://localhost:8080/
	 */
	@GetMapping(path = "/") //-> "/": raiz del proyecto 
	public String redirectIndex() {
		return "redirect:/app/index";//		/1-springboot-web/src/main/resources/templates/index.html
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/** 
	 * END-POINT    :		http://localhost:8080/
	 */
//	@GetMapping(path = {"/"}) //-> "/": raiz del proyecto 
//	public String forwardIndex() {
//		return "forward:/app/index";//		/1-springboot-web/src/main/resources/templates/index.html
//	}

}

/*
		@GetMapping(path = {"/"}) 
		public String redirectHome() {
			return "redirect:https://www.youtube.com/";
		}
*/
