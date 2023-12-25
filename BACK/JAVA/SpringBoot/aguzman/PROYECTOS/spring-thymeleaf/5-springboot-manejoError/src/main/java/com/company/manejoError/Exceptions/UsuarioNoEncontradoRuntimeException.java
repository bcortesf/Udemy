package com.company.manejoError.Exceptions;

public class UsuarioNoEncontradoRuntimeException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String mensaje;
	private Integer idUsuario;

	public UsuarioNoEncontradoRuntimeException(String mensaje) {
		super(mensaje);
		this.mensaje = mensaje;
	}
	public UsuarioNoEncontradoRuntimeException(String mensaje, Integer idUsuario) {
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
