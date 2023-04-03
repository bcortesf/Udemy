package com.empresabcf.sb.web.app.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.empresabcf.sb.web.app.models.Usuario;


@Controller
@RequestMapping(path = "/user")
public class UserController {
	//Archivo de propiedades: /spring-boot-web/src/main/resources/textos.properties
	@Value(value = "${string.usercontroller.getUserString.titulo}")
	private String tituloUsuarios;
	
	//utilidades personalizadas por mi
	public Utility util;


	public UserController() {
		util = new Utility();
	}

	@GetMapping(path = {"/getUsersString"})
	public String getUserString(org.springframework.ui.Model model) {
		String[] usersList = {"Moti","Shushi", "Minni"};
		String userString = String.join(", ", usersList);
		model.addAttribute("usersString", userString );
		model = util.getTitle(model, tituloUsuarios);
		return "users/user";//			/spring-boot-web/src/main/resources/templates/users/user.html 
	}


	@GetMapping(path = {"/getUser"})
	public String getUser(org.springframework.ui.Model model) {
		Usuario user = new Usuario();
		user.setName("Bryan");
		user.setLastName("Cortés");
		//user.setEmail("Bryan.Cortes@carvajal.com");

		model.addAttribute("user", user );
		model.addAttribute("title", "PERFIL DEL USUARIO:  ".concat(user.getName() ));
		return "users/user";//			/spring-boot-web/src/main/resources/templates/users/user.html 
	}
	@GetMapping(path = {"/getUsers"})
	public String getUsersL(org.springframework.ui.Model model) {
		java.util.List<Usuario> userList1 = java.util.Arrays.asList(
				new Usuario("Moti","CF","moti@familia.com"), 
				new Usuario("Shushi","CF","shus@familia.com") 
		);
		/*String susersList = java.util.Arrays.toString(userList2);*/

		int longitud = userList1.size();
		userList1.isEmpty();

		model.addAttribute("users", userList1 );//.size()
		model.addAttribute("tamanio", longitud );
		model = util.getTitle(model, "USUARIOS");
		return "users/userList";//			/spring-boot-web/src/main/resources/templates/users/userList.html
	}

}

/*
public class IndexController_Notas {	
	@RequestMapping(path="/index",method=RequestMethod.GET)
	public String indexUrlHtml() {
		return "index"; //nombre de la plantilla "index.html"
	}
}
*/
