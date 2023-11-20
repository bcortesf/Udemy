package com.company.di.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoSinEspacioValidadorImpl implements ConstraintValidator<RequeridoSinEspacioAnnotation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		//if ( value == null || !org.springframework.util.StringUtils.hasText(value) ) {
		if ( value == null || value.isBlank() || value.startsWith(" ") ) {
			return false;
		}
		return true;
	}

}
