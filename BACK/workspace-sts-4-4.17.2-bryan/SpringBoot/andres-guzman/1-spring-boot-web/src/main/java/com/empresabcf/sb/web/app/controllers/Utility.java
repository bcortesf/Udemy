package com.empresabcf.sb.web.app.controllers;

import org.springframework.ui.Model;

public class Utility {
	public Model getTitle(Model model, String value) {
		model.addAttribute("title", value);
		return model;
	}
}
