package com.company.web.ucommons;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MyUtility_Directo {
	public Model getTitle(Model model, String key, String value) {
		model.addAttribute(key, value);
		return model;
	}
}
