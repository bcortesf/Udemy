package com.empresabcf.sb.web.app.models;

import java.io.Serializable;

/**
 * Clase POJO: 
 * 	<p>-Usada como clase generica que no hereda y tiene sus getters & setters, por ejemplo(DAO, Entity..)
 * 	<br>-Puede implementar clases como serializable de "JAVA-JDK".  Pero NO DE (cualquier framework o api)
 */
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private String lastName;
	private String email;


	public Usuario(String name, String lastName, String email) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
	}
	public Usuario() {
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	@Override
	public String toString() {
		return "Usuario [name=" + name + ", lastName=" + lastName + ", email=" + email + "]";
	}

}

