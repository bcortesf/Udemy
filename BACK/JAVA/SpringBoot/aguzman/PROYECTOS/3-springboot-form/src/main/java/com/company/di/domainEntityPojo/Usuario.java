package com.company.di.domainEntityPojo;

import org.springframework.stereotype.Component;

// 
/** <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
 * @NotEmpty: campos no vacios
 * @Valid         : validar las anotaciones implementadas en los atributos <Usuario>
 */
import jakarta.validation.constraints.NotEmpty;

@Component
public class Usuario {
	/** 
	 * /3-springboot-form/src/main/java/com/company/di/controller/FormularioController.java
	 * @Valid:                   public String procesarFormulario_porDominioUsuario()
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

	@Override
	public String toString() {
		return "Usuario [username=" + username + ", password=" + password + ", email=" + email + "]";
	}

}
