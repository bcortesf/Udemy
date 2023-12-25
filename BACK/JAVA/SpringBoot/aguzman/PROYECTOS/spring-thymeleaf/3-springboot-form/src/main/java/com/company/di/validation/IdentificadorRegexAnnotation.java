package com.company.di.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * ENLAZAR CON MI VALIDADOR:		/3-springboot-form/src/main/java/com/company/di/validation/IdentificadorRegexValidadorImpl.java
 */
@Constraint(validatedBy = IdentificadorRegexValidadorImpl.class)

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface IdentificadorRegexAnnotation {
	/**
	 * @return the error message template
	 */
//	String message() default "Identificador \"IdRegex2\" inválido";		//OPCION#1		:Mensaje-directo
	String message() default "{anotacionAlias.usuario.idRegex2}";		//OPCION#2		:archivo-propiedad SI-LA-ANOTACION-NO-EXISTE en <Usuario>   -   /3-springboot-form/src/main/resources/messages.properties

	/**
	 * Es para agrupar validadores
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default { };

	/**
	 * @return the payload associated to the constraint
	 */
	Class<? extends Payload>[] payload() default { };
}
