package com.company.di.commons.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.di.service.ICiudadService;

@Component
public class CiudadPropertyEditor extends PropertyEditorSupport {
	//ALT+SHIFT+S  ->  Override/Implements Methods...

	@Autowired
	private ICiudadService ciudadService;

	
	@Override
	public void setAsText(String idStringCiudad) throws IllegalArgumentException {
		if (!idStringCiudad.isBlank()) {
			Integer idCiudad = Integer.parseInt(idStringCiudad);
			this.setValue( ciudadService.findCiudadBy(idCiudad).get() );
		} else {
			this.setValue(null);
		}
	}

}
