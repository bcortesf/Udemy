package com.company.di.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.di.domainEntityPojo.Usuario;

@Component
public class UsuarioValidador implements Validator {

	/**
	 * Que clase Entity o POJO, vamos a validar
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario.class.isAssignableFrom(clazz);
	}

	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/18417368?start=340#notes
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Usuario usuario = (Usuario) target;
		/**
		 * "telefono"                          	: /3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario.java
		 * "Pattern.usuario.telefono"	: /3-springboot-form/src/main/resources/messages.properties
		 */
		//sin numero ó con numero de 10 digitos
		if (usuario.getTelefono().matches("[0-9]{0,10}") == false) {
			errors.rejectValue("telefono", "Pattern.usuario.telefono");
		}
		
		//------------------------------------------------------------------------------------------------------
		/*OPCION #1*/
//		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty.usuario.username");
		/*OPCION #2*/
//		if (usuario.getUsername().isBlank()) {
//			errors.rejectValue("username", "NotEmpty.usuario.username");
//		}

	}

}
