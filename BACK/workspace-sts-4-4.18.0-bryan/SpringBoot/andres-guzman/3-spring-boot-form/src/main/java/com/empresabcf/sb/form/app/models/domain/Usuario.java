package com.empresabcf.sb.form.app.models.domain;

import org.springframework.stereotype.Component;
import jakarta.validation.constraints.NotEmpty;

@Component
public class Usuario {
	/**
	 * /3-spring-boot-form/src/main/java/com/empresabcf/sb/form/app/controllers/FormularioController.java
	 * Valida cada campo segun el objeto "@Valid Usuario usuario" por la notacion @Valid
	 */
	@NotEmpty private String username;
	@NotEmpty private String password;
	@NotEmpty private String email;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
