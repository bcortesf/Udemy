package com.empresabcf.sb.web.app.controllers;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;



/**										@algo (anotación o decorador)
 * @Controller: Marca o configura esta clase como  un componente de spring pero de tipo controlador
 */
@Controller
@RequestMapping(path = "/app")
public class IndexController {
	@Value(value = "${string.indexcontroller.indexPrincipal.contenidoFooter}") 
	private String contenidoFooter;
	@Value(value = "${string.indexcontroller.indexPrincipal.autorFooter}") 
	private String autorFooter;
	
	/**
	 * <h1>metodoMapeadoAMasDeUnaRutaURL</h1>
	 * <h2>Las dos sintaxis son equivalentes</h2>
	    <ul>   <li>@RequestMapping(path="/index",method=RequestMethod.GET)</li>  <li>@GetMapping(path = "/index")</li>   </ul>					     
	 * - LLamado por POSTMAN, se accede con el valor  "path"
	      <br>localhost:8080/{path} 
	      <br>localhost:8080/index,  localhost:8080/app/,  localhost:8080/home
	 */
	@GetMapping(path = {"/index",  "/",  "",  "/home", "/app"})
	public String indexPrincipal(org.springframework.ui.Model model) {
		model.addAttribute("titleWindow", "BCF-App");
		model.addAttribute("title", "Hola Spring!");
		model.addAttribute("content", "Esto es Spring-Boot");
		model.addAttribute("contentFooter", contenidoFooter);//spring-boot-web/src/main/resources/application.properties = @Value
		model.addAttribute("authorFooter", autorFooter);     //spring-boot-web/src/main/resources/application.properties = @Value
		return "index";//			/spring-boot-web/src/main/resources/templates/index.html
	}

}


//->PARAMETRO DE MODELO, , USANDO CLASES DISTINTAS CON LA MISMA FUNCION
/*
public class IndexController_Notas {	
	@RequestMapping(path="/index",method=RequestMethod.GET)
	public String indexUrlHtml() {
		return "index"; //nombre de la plantilla "index.html"
	}
	@GetMapping(path = {"/index",  "/",  "",  "/home"})
	public String metodoMapeadoAMasDeUnaRutaURL(org.springframework.ui.Model model) {
		model.addAttribute("titleWindow", "BCF-App");		model.addAttribute("title", "Hola Spring!");		model.addAttribute("content", "Esto es Spring-");
		return "index"; 
	}
	@GetMapping(path = {"/index",  "/",  "",  "/home"})
	public String metodoMapeadoAMasDeUnaRutaURL(org.springframework.ui.ModelMap mp) {
		mp.addAttribute("titleWindow", "BCF-App");		mp.addAttribute("title", "Hola Spring!");		mp.addAttribute("content", "Esto es Spring-");
		return "index"; 
	}
	@GetMapping(path = {"/index",  "/",  "",  "/home"})
	public String metodoMapeadoAMasDeUnaRutaURL2(java.util.Map<String, Object> map) {
		map.put("titleWindow", "BCF-App1");		map.put("title", "Hola Spring!");		map.put("content", "Esto es Spring-");
		return "index"; 
	}
	@GetMapping(path = {"/index",  "/",  "",  "/home"})
	public org.springframework.web.servlet.ModelAndView  metodoMapeadoAMasDeUnaRutaURL( org.springframework.web.servlet.ModelAndView mv) {
		mv.addObject("titleWindow", "BCF-App");		mv.addObject("title", "Hola Spring-");		mv.addObject("content", "Esto es Spring-");
		mv.setViewName("index"); //->nombre-de-la-vista.html
		return mv;
	}
}
*/
