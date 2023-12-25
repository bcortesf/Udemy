package com.company.web.ucommons;

import org.springframework.ui.Model;

public class MyUtility_conInstanciaAppConfig {
	public Model getTitle(Model model, String key, String value) {
		model.addAttribute(key, value);
		return model;
	}
}
