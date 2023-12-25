package com.company.di.service;

/**
 *  En un ejemplo real con base de datos , el service contendria metodos para implementar un crud
 * - listar, guardar, eliminar, modificar,
 *  filtrar por nombre..
 *  Retornaria: lista de objetos, un objeto que este mapeado alguna tabla (un entity, un pojo) etc
 */
public class Servicio_NOInyectado {

	public String Operacion() {
		String usuario = "Obteniendo usuario[Bryan]    :".concat(getClass().getName());
		return usuario;
	}
	
	public String[] OperacionLista() {
		String[] listaUsuario = {
				"Obteniendo usuario[Bryan]    :",
				getClass().getName()
		};
		return listaUsuario;
	}

}
