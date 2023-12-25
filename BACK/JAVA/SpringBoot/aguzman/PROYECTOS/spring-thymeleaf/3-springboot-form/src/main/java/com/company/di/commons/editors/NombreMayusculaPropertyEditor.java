package com.company.di.commons.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaPropertyEditor extends PropertyEditorSupport{
	//	Click-derecho: Override / Implement Methods..
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(text.toUpperCase().trim());
	}

}
