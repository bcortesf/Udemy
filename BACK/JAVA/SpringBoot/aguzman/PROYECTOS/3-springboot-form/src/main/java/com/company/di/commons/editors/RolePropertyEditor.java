package com.company.di.commons.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.di.service.IRoleService;

@Component
public class RolePropertyEditor extends PropertyEditorSupport {
	//ALT+SHIFT+S  ->  Override/Implements Methods...

	@Autowired IRoleService roleService;
	
	@Override
	public void setAsText(String idRoleString) throws IllegalArgumentException {
		try {
			Integer idRole = Integer.parseInt(idRoleString);
			setValue( roleService.findById(idRole).get() );
		} catch (NumberFormatException e) {
			setValue(0); //setValue(null);
		}
	}

}
