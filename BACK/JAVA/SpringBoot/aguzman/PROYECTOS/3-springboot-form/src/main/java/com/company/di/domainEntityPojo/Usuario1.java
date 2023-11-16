package com.company.di.domainEntityPojo;

import org.springframework.stereotype.Component;

import com.company.di.constantes.UsuarioCustomMessages;
import com.company.di.validation.IdentificadorRegexAnnotation;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
// 
/** <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
 * @NotEmpty: campos no vacios
 * @Valid         : validar las anotaciones implementadas en los atributos <Usuario>
 */
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Component
public class Usuario1 {
	private String identificadorUsuario; //SESSION-ATRIBUTE
	
	/** 
	 * /3-springboot-form/src/main/java/com/company/di/controller/FormularioController.java
	 * @Valid:                   public String procesarFormulario_porDominioUsuario()
	 * 
	 * 
	 * ***REGLAS-PARA-MENSAJES-PERSONALIZADOS-EN-@ANOTACIONES ***
	 * - Se define mensajes customizables para las anotaciones, donde reemplaza o sobreescribe los mensajes. EJEMPLO: @NotEmpty.
	 *   /3-springboot-form/src/main/resources/messages.properties
	 */
	
	@NotEmpty
						private String pais=""; //default, por getMapping("/form")
	
	@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}", message = "ejemplo de formato:  19.234.765-B")
						private String idRegex;
						
    //@Pattern(regexp = "[0-9]{0,10}")
    					private String telefono;//impl_claseValidador		:/3-springboot-form/src/main/java/com/company/di/validation/UsuarioValidador.java
    
	@NotBlank @Size(min = 3, max = 8, message = "La longitud del  \"username\" no es válida, debe estar entre {min} y {max}.")
						private String username;
	
	@NotEmpty(message = "IGNORA ESTE MENSAJE, PORQUE LO TOMA DE 'messages.properties'")
						private String password;//Lectura archivo-propiedad	:/3-springboot-form/src/main/resources/messages.properties
	
	//@NotEmpty @Email(message = "Incluye un signo \"@\" en la dirección de correo eletrónico. La dirección  no incluye el signo \"@\"")
	@NotEmpty @Email(message = UsuarioCustomMessages.EMAIL_MESSAGE2)
	                     private String email;
	
	
	
	@Override
	public String toString() {
		return "Usuario1 [identificadorUsuario=" + identificadorUsuario + ", pais=" + pais + ", idRegex=" + idRegex
				+ ", telefono=" + telefono + ", username=" + username + ", password=" + password + ", email=" + email
				+ "]";
	}

	/*GETTERS && SERTTERS*/
	//----------------------------------------------------------------------------------
	//                         **SESSION-ATRIBUTE**
	public String getIdentificadorUsuario() {
		return identificadorUsuario;
	}
	public void setIdentificadorUsuario(String identificadorUsuario) {
		this.identificadorUsuario = identificadorUsuario;
	}
	//----------------------------------------------------------------------------------
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getIdRegex() {
		return idRegex;
	}
	public void setIdRegex(String idRegex) {
		this.idRegex = idRegex;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
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
