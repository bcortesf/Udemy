package com.company.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.web.model.Usuario;
import com.company.web.ucommons.MyUtility_Directo;

@Controller
@RequestMapping(path = "/user")
public class UserController {
	private Logger LOG = LoggerFactory.getLogger(getClass());

	//Archivo de propiedades: /spring-boot-web/src/main/resources/textos.properties
	@Value(value = "${string.usercontroller.getUserString.titulo}")
	private String tituloUsuarios;
	
	/**  OPCION #1	:CREAR INSTANCIA EN CONTENEDOR SPRING-BOOT
	 * Crear instancia singleton, en una clase de @Configuration
	 * 1-springboot-web/src/main/java/com/company/web/configuration/AppConfig.java
	 */
//	@Autowired
//	private MyUtility_conInstanciaAppConfig util;
	
	/**  OPCION #1	:CREAR INSTANCIA EN CONTENEDOR SPRING-BOOT
	 *  Crear instancia singleton, mapeando una clase con el stereotipo @Component
	 * /1-springboot-web/src/main/java/com/company/web/ucommons/MyUtility_Directo.java
	 */
	@Autowired
	private MyUtility_Directo util;
	
	/*
	 * http://localhost:8080/user/getUsersString
	 */
	@GetMapping(path = {"/getStrings"})
	public String getUserString(org.springframework.ui.Model model) {
		String[] usersList = {"Moti","Shushi", "Minni"};
		String userString = String.join(", ", usersList);

		model.addAttribute("usersString", userString );
		model.addAttribute("titleWindow", "User String" );
		model.addAttribute("title", "Strings" );
		model = util.getTitle(model, "subtitle", tituloUsuarios);
		return "user/strings_objPerfil";//			/1-springboot-web/src/main/resources/templates/user/strings_objPerfil.html
	}
	/*
	 * http://localhost:8080/user/getUser
	 */
	@GetMapping(path = {"get"})
	public String getUser(org.springframework.ui.Model model) {
		Usuario user = new Usuario();
		user.setName("Bryan");
		user.setLastName("Cortés");
		/*PROBAR-VALIDACION: 
		 * comentariando linea de correo  [email=null],
		 * dejandolo [email="bcortesf2@gmail.com"]
		 * */
//		user.setEmail("bcortesf2@gmail.com");
		LOG.info("email=" + user.getEmail());

		model.addAttribute("user", user );
		model.addAttribute("titleWindow", "User Obj" );
		model.addAttribute("title", "Objeto" );
		model.addAttribute("subtitle", "PERFIL DEL USUARIO:  ".concat(user.getName() ));
		return "user/strings_objPerfil";//			/1-springboot-web/src/main/resources/templates/user/strings_objPerfil.html
	}
	/*
	 *  http://localhost:8080/user/list
	 */
	@SuppressWarnings("unused")
	@GetMapping(path = {"/list"})
	public String getUsersList(org.springframework.ui.Model model) {
		java.util.List<Usuario> userListFU = java.util.Arrays.asList(   //LISTA LLENA
				new Usuario("Moti","CF","moti2006@familia.com"), 
				new Usuario("Shushi","CF","shus2013@familia.com"),
				new Usuario("Minnie","CF","mini2022@familia.com")
		);
		java.util.List<Usuario> userListEM = java.util.Arrays.asList();   //LISTA VACIA

		//Cambiar test    (userListFU <--> userListEM)
		model.addAttribute("users", userListFU );            //.size(), .isEmpty(), ...etc
		model.addAttribute("tamanio", userListFU.size() );
		model.addAttribute("titleWindow", "Users list" );
		model = util.getTitle(model, "title", "USUARIOS");
		return "user/list";//			/1-springboot-web/src/main/resources/templates/users/list.html
	}

}
