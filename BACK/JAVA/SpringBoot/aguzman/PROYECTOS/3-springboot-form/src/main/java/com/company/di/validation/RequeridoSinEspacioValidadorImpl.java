package com.company.di.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class RequeridoSinEspacioValidadorImpl implements ConstraintValidator<RequeridoSinEspacioAnnotation, String> {

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		if (!value.isBlank()) {
			return true;
		}
		return false;
	}

}
