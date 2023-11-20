package com.company.di.domainEntityPojo;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Component;

import com.company.di.commons.constantes.UsuarioCustomMessages;
import com.company.di.validation.IdentificadorRegexAnnotation;
import com.company.di.validation.RequeridoSinEspacioAnnotation;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
// 
/** <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation -->
 * @NotEmpty: campos no vacios
 * @Valid         : validar las anotaciones implementadas en los atributos <Usuario>
 */
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Component
public class Usuario2 {
	/** 
	 * /3-springboot-form/src/main/java/com/company/di/controller/FormularioController.java
	 * @Valid:                   public String procesarFormulario_porDominioUsuario()
	 * 
	 * 
	 * ***REGLAS-PARA-MENSAJES-PERSONALIZADOS-EN-@ANOTACIONES ***
	 * - Se define mensajes customizables para las anotaciones, donde reemplaza o sobreescribe los mensajes. EJEMPLO: @NotEmpty.
	 *   /3-springboot-form/src/main/resources/messages.properties
	 */
	
	@RequeridoSinEspacioAnnotation
		private String pais;//anotacion_personalizada		:/3-springboot-form/src/main/java/com/company/di/validation/RequeridoSinEspacioAnnotation.java
	
	@IdentificadorRegexAnnotation       //### Cuando la anotacion existe, de forma automatica SPRING HACE EL MATCH DEL MENSAJE:  EN ARCHIVO-PROPIEDAD
		private String idRegex2;//anotacion_personalizada		:/3-springboot-form/src/main/java/com/company/di/validation/IdentificadorRegexAnnotation.java
						
    //@Pattern(regexp = "[0-9]{0,10}")
		private String telefono;//impl_claseValidador		:/3-springboot-form/src/main/java/com/company/di/validation/UsuarioValidador2.java
    					
		private String nombre;//impl_claseValidador		:/3-springboot-form/src/main/java/com/company/di/validation/UsuarioValidador2.java
    
	@NotEmpty @Email(message = UsuarioCustomMessages.EMAIL_MESSAGE2)
		private String email;
	
	/**
	 *@NotEmpty, @NotBlank	:Para TEXTO    , tipo <String>
	 *@NotNull 							:Para OBJETOS, tipo <Integer><DateTime>...etc
	 *@Min, @Max					    :Para primitivos, tipo <int><double>...etc
	 */
	@NotNull(message = "No puede ser vacio")
	@Max(value = 99, message = "El maximo son dos digitos, hasta 99")
	@Min(value = 10, message =  "El minimo son dos digitos, hasta 10")
		private Integer  numeroCuenta;


	/**
	 * ***NO ES OBLIGATORIO***.  -> SIRVE PARA VALIDAR UNA FECHA SEGUN UN CRITERIO
	 * @jakarta.validation.constraints.Past()
	 * @jakarta.validation.constraints.PastOrPresent()
	 * @jakarta.validation.constraints.Future()
	 * @jakarta.validation.constraints.FutureOrPresent()
	 */
	@NotNull(message = "La fechaNacimiento no puede ser vacio")
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "M/d/yy", "dd.MM.yyyy", "yyyy-MM-dd" }) //fallbackPatterns: Formatos de fecha que acepta
		private LocalDate fechaNac;
	@NotNull(message = "La fechaNacimiento2 no puede ser vacio")
	@DateTimeFormat(iso = ISO.DATE, fallbackPatterns = { "yyyy-MM-dd" }) //fallbackPatterns: Formatos de fecha que acepta
	@jakarta.validation.constraints.Past()
		private LocalDate fechaNac2;
	@NotNull(message = "La fechaNacimiento3 no puede ser vacio")
	@jakarta.validation.constraints.Future()
		private Date fechaNac3;


	@NotEmpty(message = "Debe seleccionar un pais")
		private String paisSelectStr;
	
	//Validacion dentro de la clase, por atributo en especifico, orientado al select
		@Valid
		private Pais paisSelectObj;
	
	
	@Override
	public String toString() {
		return "Usuario2 [pais=" + pais + ", idRegex2=" + idRegex2 + ", telefono=" + telefono + ", nombre=" + nombre
				+ ", email=" + email + ", numeroCuenta=" + numeroCuenta + ", fechaNac=" + fechaNac + ", fechaNac2="
				+ fechaNac2 + ", fechaNac3=" + fechaNac3 + ", paisSelectStr=" + paisSelectStr + ", paisSelectObj="
				+ paisSelectObj + "]";
	}
							
	/*GETTERS && SERTTERS*/
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public String getIdRegex2() {
		return idRegex2;
	}
	public void setIdRegex2(String idRegex2) {
		this.idRegex2 = idRegex2;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(Integer numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(LocalDate fechaNac) {
		this.fechaNac = fechaNac;
	}
	public LocalDate getFechaNac2() {
		return fechaNac2;
	}
	public void setFechaNac2(LocalDate fechaNac2) {
		this.fechaNac2 = fechaNac2;
	}
	public Date getFechaNac3() {
		return fechaNac3;
	}
	public void setFechaNac3(Date fechaNac3) {
		this.fechaNac3 = fechaNac3;
	}
	
	public String getPaisSelectStr() {
		return paisSelectStr;
	}
	public void setPaisSelectStr(String paisSelectStr) {
		this.paisSelectStr = paisSelectStr;
	}
	public Pais getPaisSelectObj() {
		return paisSelectObj;
	}
	public void setPaisSelectObj(Pais paisSelectObj) {
		this.paisSelectObj = paisSelectObj;
	}

}
