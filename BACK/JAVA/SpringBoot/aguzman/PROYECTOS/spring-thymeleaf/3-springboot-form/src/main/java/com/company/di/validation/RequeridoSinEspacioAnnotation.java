package com.company.di.validation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

/**
 * ENLAZAR CON MI VALIDADOR:		/3-springboot-form/src/main/java/com/company/di/validation/RequeridoSinEspacioValidadorImpl.java
 */
@Constraint(validatedBy = RequeridoSinEspacioValidadorImpl.class)

@Retention(RUNTIME)
@Target({ FIELD, METHOD })
public @interface RequeridoSinEspacioAnnotation {
	/**
	 * @return the error message template
	 */
	String message() default "el campo es *Obligatorio y no debe contener espacios en blanco";

	/**
	 * @return the groups the constraint belongs to
	 */
	Class<?>[] groups() default { };

	/**
	 * @return the payload associated to the constraint
	 */
	Class<? extends Payload>[] payload() default { };
}
