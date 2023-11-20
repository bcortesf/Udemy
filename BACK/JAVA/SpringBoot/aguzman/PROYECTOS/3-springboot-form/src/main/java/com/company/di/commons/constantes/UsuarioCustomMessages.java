package com.company.di.commons.constantes;

import org.springframework.stereotype.Component;

@Component
public class UsuarioCustomMessages {

	/**
	 * https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/?v=6.1#_examples
	 *  ${validatedValue}
	 */
    public static final String EMAIL_MESSAGE1 = "El correo electrónico no es válido. Por favor, proporcione un correo electrónico válido: ${validatedValue}";
    public static final String EMAIL_MESSAGE2 = "Incluye un signo \"@\" en la dirección de correo eletrónico. La dirección  \"${validatedValue}\"    no incluye el signo \"@\".";
}
