package com.company.manejoError.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.company.manejoError.Exceptions.UsuarioNoEncontradoException;
import com.company.manejoError.Exceptions.UsuarioNoEncontradoRuntimeException;
import com.company.manejoError.domainEntityPojo.Usuario;
import com.company.manejoError.service.IUsuarioService;

@Controller
public class UsuarioController {
	Logger LOG = LoggerFactory.getLogger(getClass());

	@Autowired
	  private IUsuarioService usuarioService;

	@GetMapping(path = {"usuarios"})
	public String usuariosLista(Model model) {
		LOG.info("usuariosList: " + usuarioService.listar());
		model.addAttribute("usuariosList", usuarioService.listar());
		return "usuario/usuarios";//HTML:
	}


	
	@GetMapping(path = {"verE/{idUsuario}"})
	public String usuarioBuscarExeption (
			@PathVariable(name = "idUsuario") int idUsuario,Model model) throws UsuarioNoEncontradoException {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		
		/*PRUEBA	:Error<500> - USUARIO NO ENCONTRADO POR ID      , @ExceptionHandler(value = {UsuarioNoEncontradoException.class})*/
		Usuario usuarioEncontrado = usuarioService.obtenerPorId_Exeption(idUsuario);
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		LOG.info("EXITOSO");
		model.addAttribute("usuarioEncontrado", usuarioEncontrado);
		return "usuario/ver";//HTML:
	}



	@GetMapping(path = {"verR1/{idUsuario}"})
	public String usuarioBuscarRuntimeExeption1 (
			@PathVariable(name = "idUsuario") int idUsuario,Model model)  {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		
		/*PRUEBA	:Error<500> - USUARIO NO ENCONTRADO POR ID      , @ExceptionHandler(value = {UsuarioNoEncontradoRuntimeException.class})*/
		Usuario usuarioEncontrado = usuarioService.obtenerPorId_RuntimeExeption1(idUsuario);
		/*******OPCION#1:	VALIDACION POR -> CAPA-CONTROLADORA*******/
		if (usuarioEncontrado == null) {
			throw new UsuarioNoEncontradoRuntimeException(
					"No se encontro el usuario con ID<".concat(String.valueOf(idUsuario)).concat(">")
					,idUsuario	
			);
		}		
		System.err.println("<controlador><usuarioEncontrado1>" + usuarioEncontrado);
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		LOG.info("EXITOSO");
		model.addAttribute("usuarioEncontrado", usuarioEncontrado);
		return "usuario/ver";//HTML:
	}


	@GetMapping(path = {"verR2/{idUsuario}"})
	public String usuarioBuscarRuntimeExeption2 (
			@PathVariable(name = "idUsuario") int idUsuario,Model model)  {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		
		/*PRUEBA	:Error<500> - USUARIO NO ENCONTRADO POR ID      , @ExceptionHandler(value = {UsuarioNoEncontradoRuntimeException.class})*/
		/*******OPCION#2:	VALIDACION POR -> CAPA-SERVICE*******/
		Usuario usuarioEncontrado = usuarioService.obtenerPorId_RuntimeExeption2(idUsuario);
		System.err.println("<controlador><usuarioEncontrado2>" + usuarioEncontrado);
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		LOG.info("EXITOSO");
		model.addAttribute("usuarioEncontrado", usuarioEncontrado);
		return "usuario/ver";//HTML:
	}


	@GetMapping(path = {"verR3/{idUsuario}"})
	public String usuarioBuscarRuntimeExeption3 (
			@PathVariable(name = "idUsuario") int idUsuario,Model model)  {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		
		/*PRUEBA	:Error<500> - USUARIO NO ENCONTRADO POR ID      , @ExceptionHandler(value = {UsuarioNoEncontradoRuntimeException.class})*/
		/*******OPCION#3:	VALIDACION POR -> CAPA-SERVICE*******/
		Usuario usuarioEncontrado = usuarioService.obtenerPorId_RuntimeExeption3(idUsuario);
		System.err.println("<controlador><usuarioEncontrado3>" + usuarioEncontrado);
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		LOG.info("EXITOSO");
		model.addAttribute("usuarioEncontrado", usuarioEncontrado);
		return "usuario/ver";//HTML:
	}


	@GetMapping(path = {"verR4/{idUsuario}"})
	public String usuarioBuscarRuntimeExeption4 (
			@PathVariable(name = "idUsuario") int idUsuario,Model model)  {
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
		/**						**PAGINA HTML DE ERRORRES, por @ControllerAdvice**
		 * /5-springboot-manejoError/src/main/java/com/company/manejoError/controller/ErrorHandlerController.java
		 * Carga un HTML customizado para cada exepcion	:"error/Aritmetico.HTML"
		 */
		
		/*PRUEBA	:Error<500> - USUARIO NO ENCONTRADO POR ID      , @ExceptionHandler(value = {UsuarioNoEncontradoRuntimeException.class})*/
		/*******OPCION#4:	VALIDACION POR -> CAPA-SERVICE*******/
		Usuario usuarioEncontrado = usuarioService.obtenerPorId_Optional(idUsuario)
				.orElseThrow(() -> new UsuarioNoEncontradoRuntimeException(
						/*******OPCION#3:	VALIDACION POR -> CAPA-SERVICE*******/	
						"No se encontro el usuario con ID<<<<".concat(String.valueOf(idUsuario)).concat(">>>>")
						, idUsuario));;
		System.err.println("<controlador><usuarioEncontrado4>" + usuarioEncontrado);
		///////////////////////////////////////////////////////////////////////////////////////////////////////

		LOG.info("EXITOSO");
		model.addAttribute("usuarioEncontrado", usuarioEncontrado);
		return "usuario/ver";//HTML:
	}
}
