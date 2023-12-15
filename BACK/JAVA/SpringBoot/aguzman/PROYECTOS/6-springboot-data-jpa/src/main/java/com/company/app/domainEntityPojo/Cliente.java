package com.company.app.domainEntityPojo;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "clientes")//,schema = ""
public class Cliente implements Serializable {
	/**
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/19248470?start=58#notes
	 * https://www.udemy.com/course/spring-framework-5/learn/lecture/14635654?start=163#notes
	 * Se usa por ejemplo para:
	 * 	- guardar el objeto en una sesion HTTP
	 *  - convertir a bytes, trabajar con la instancia
	 *  - transferir objeto de forma remota
	 *  
	 *  El proceso de convertir el objeto en una secuencia de bytes, se requiere <SERIALIZAR> para:
	 *  - almacenarlo ó transmitirlo a: (la memoria, una base datos, un JSON, XML, sesiones HTTP )
	 */
	private static final long serialVersionUID = 1L;
	//////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * strategy = GenerationType.IDENTITY	->	"MYSQL, SQLSERVER, H2"
	 * strategy = GenerationType.SEQUENCE	->	"ORACLE, POSGRESQL"
	 */
	@Id													//Define llave primaria
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Estrategia_Autoincrementable
	  private Long id;
	private String nombre;
	private String apellido;
	private String correo;
	@Column(name = "create_at")          //alias: como se llamara en la "BD"
	@Temporal(value = TemporalType.DATE) //tipo : como se almacenara el tipo de dato en la "BD" =Map as java.sql.Date
	  private java.util.Date createAt;


	public Cliente() {}
	public Cliente(Long id, String nombre, String apellido, String correo, Date createAt) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.createAt = createAt;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public java.util.Date getCreateAt() {
		return createAt;
	}
	public void setCreateAt(java.util.Date createAt) {
		this.createAt = createAt;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", createAt=" + createAt + "]";
	}

}
