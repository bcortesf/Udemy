package com.company.di.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

/**
 * /3-springboot-form/src/main/java/com/company/di/domainEntityPojo/Usuario.java
 * 
 * ConstraintValidator<AnotacionPersonalizada, Campo-a-validar>
 *                                   @interfaceAnottation , <Usuario>.idRegex2
 */
public class IdentificadorRegexValidadorImpl implements ConstraintValidator<IdentificadorRegexAnnotation, String> {

	/**
	 * String value: Corresponde a <Usuario>.idRegex2
	 */
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (value.matches( "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")) {
			return true;
		}
		return false;
	}

}
