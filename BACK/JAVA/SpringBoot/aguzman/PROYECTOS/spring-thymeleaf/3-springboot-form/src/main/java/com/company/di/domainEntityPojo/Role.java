package com.company.di.domainEntityPojo;

public class Role {
	
	private Integer id;
	private String tipoRol;//ROL_ADMIN, ROL_USER
	private String nombre;//Administrador,Usuario
	
	
	public Role() {
	}
	public Role(Integer id, String tipoRol, String nombre) {
		this.id = id;
		this.tipoRol = tipoRol;
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipoRol() {
		return tipoRol;
	}
	public void setTipoRol(String tipoRol) {
		this.tipoRol = tipoRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", tipoRol=" + tipoRol + ", nombre=" + nombre + "]";
	}

}
