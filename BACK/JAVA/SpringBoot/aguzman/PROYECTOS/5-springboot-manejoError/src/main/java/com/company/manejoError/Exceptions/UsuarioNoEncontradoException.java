package com.company.manejoError.Exceptions;

public class UsuarioNoEncontradoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private Integer idUsuario;

	public UsuarioNoEncontradoException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
	public UsuarioNoEncontradoException(String mensaje, Integer idUsuario) {
		super(mensaje);
		this.mensaje = mensaje;
		this.idUsuario = idUsuario;
	}


	public String getMensaje() {
		return mensaje;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	
	
	
}
