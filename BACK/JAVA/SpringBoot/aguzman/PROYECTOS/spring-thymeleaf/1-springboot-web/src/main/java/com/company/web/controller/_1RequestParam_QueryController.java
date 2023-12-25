package com.company.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

/**
 * 													PARAMETROS DE CONSULTA 
 * https://es.stackoverflow.com/questions/380131/cual-es-basicamente-la-diferencia-entre-la-anotacion-requestparam-y-pathvari
 * @RequestParam: Capturar los parametros de una url, para filtrar consultas                    GET /user?id=123
 * @PathVariable    : Dirigir a un componente o un dato especifico, ej: id, cedula                GET /user/123
 * 
 * GET /user/@PathVariable?@RequestParam=true
 * GET /user/123                  ?friends=true
 * GET /user/123?friends=true
 */
@Controller
@RequestMapping(path = "/requestParams")
public class _1RequestParam_QueryController {
	@Value(value= "${protocolo.dominio.puerto}") private String RUTA_PROYECTO;
	///////////////////////////////////////////////////////////////////
	@GetMapping(path = "/index")
	public String index(Model model) {
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/indexRequestParam";//	//1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/indexRequestParam.html
	}
	///////////////////////////////////////////////////////////////////

	/**
	 * END-POINT:		../requestParams/string?param1=Moticas&param3=Shushi y Minni
	 * END-POINT:		../requestParams/string?param1=Moticas&param2=&param3=Shushi y Minni&param4=*___*&param5=canarios
	 */
	@GetMapping(path = "/string")
	public String parametro(
			@RequestParam(name = "param1") String texto1, 				                 //nombre-parametro:<param1>,  alias:<texto1>
			@RequestParam(name = "param2", 
					defaultValue = "SIN VALOR EL parametro2") String texto2,        //parametro-valor-default:<param2>; SOLO-SI en la url no existe el parametro
			@RequestParam(name = "param3", required = true) String texto3, 	 // parametro:<param3> obligatorio
			@RequestParam(name = "param4", required = false) String texto4, // parametro:<param4> opcional
			@RequestParam String param5, 													    // parametro:<param5>; parametro:(nombre <=> alias)
			Model model) {
		model.addAttribute("resultado1", "El texto1 enviado es:".concat(texto1));
		model.addAttribute("resultado2", "El texto2 enviado es:".concat(texto2));
		model.addAttribute("resultado3", "El texto3 enviado es:".concat(texto3));
		model.addAttribute("resultado4", texto4);
		model.addAttribute("resultado5", "El param enviado es:".concat(param5));
		
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/ver";//	/1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/ver.html
	}

    //____________________________________________________________________________________________________________
	/**
	 * @RequestParam    :FORMA-MODERNA
	 * END-POINT:		../requestParams/mix-params?paramSaludo=Hola%20Bryan&paramAño=2023
	 */
	@GetMapping(path = "/mix-params")
	public String param(@RequestParam String paramSaludo, @RequestParam Integer paramAño, Model model) {
		model.addAttribute("resultado3",		"El saludo enviado es: '" + paramSaludo + "' en el año: " + paramAño);
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/ver";//	/1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/ver.html
	}
	/**
	 * @Param    :HttpServletRequest request,   FORMA-ANTIGUA, sin decorador, manejar excepciones
	 * END-POINT:		../requestParams/mix-params-request?paramSaludo=Hola%20Bryan&paramAño=2023
	 */
	@GetMapping(path = "/mix-params-request")
	public String param(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("pmsaludo");
		Integer año   = null;
		try {
			año   = Integer.parseInt( request.getParameter("pmaño") ); //valor-parametro
			//año   = Integer.parseInt( request.getParameter("nombreParamNoExiste") ); // ENTRAR AL CATCH
		} catch (NumberFormatException e) {
			año = 0;
		}
		model.addAttribute("resultado3",		"El saludo enviado es: '" + saludo + "' en el año: " + año);
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/ver";//	/1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/ver.html
	}
	//____________________________________________________________________________________________________________

	/** mostrar-formulario
	 * END-POINT	  :		../requestParams/verFormulario
	 * REDIRECT-TO:		http://localhost:8080/requestParams/verFormulario
	 */
	@GetMapping(path = "/verFormulario")
	public String getFormulario(Model model) {
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/formulario";//	/1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/formulario.html
	}
	/** enviarDatosFormulario y visualizar en otro HTML
	 * END-POINT	  :		../requestParams/enviarFormulario
	 * REDIRECT-TO:		http://localhost:8080/requestParams/enviarFormulario
	 */
	@PostMapping(path = {"/enviarFormulario"})
	public String setFormulario(
			@RequestParam String nombre, @RequestParam String apellido, @RequestParam String correo,  //<formulario.html>[name="nombre", name="apellido", name="correo"]
			Model model) {
		model.addAttribute("resultado1", "Nombre: ".concat(nombre));
		model.addAttribute("resultado2", "Apellido: ".concat(apellido));
		model.addAttribute("resultado3", "Correo: ".concat(correo));
		model.addAttribute("MY_PATH", RUTA_PROYECTO);            //1-springboot-web/src/main/resources/textos.properties = @Value
		return "1ResquestParam_parametro/ver";//	/1-springboot-web/src/main/resources/templates/1ResquestParam_parametro/ver.html
	}

}
