package com.company.di.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.company.di.domainEntityPojo.Usuario1;

@Component
public class UsuarioValidador1 implements Validator {

	/**
	 * Que clase Entity o POJO, vamos a validar
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Usuario1.class.isAssignableFrom(clazz);
	}

	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/18417368?start=340#notes
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Usuario1 usuario = (Usuario1) target;
		/**
		 * "telefono"                          	: /3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario1.java
		 * "Pattern.usuario.telefono"	: /3-springboot-form/src/main/resources/messages.properties
		 */
		String[] PHONE_REGEXS = {
				"[0-9]{0,10}", //NUMERO-10-DIGITOS_O_SIN-NUMERO
				"[0-9]{010}"   //NUMERO-10-DIGITOS
		};
		
		//NUMERO-10-DIGITOS
		if (usuario.getTelefono().matches(PHONE_REGEXS[1]) == false) {
			errors.rejectValue("telefono", "Pattern.usuario.telefono");
		}

	}

}
