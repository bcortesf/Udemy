package com.company.manejoError.service;

import java.util.List;
import java.util.Optional;

import com.company.manejoError.Exceptions.UsuarioNoEncontradoException;
import com.company.manejoError.Exceptions.UsuarioNoEncontradoRuntimeException;
import com.company.manejoError.domainEntityPojo.Usuario;

public interface IUsuarioService {
	List<Usuario> listar();
	
	Usuario obtenerPorId_Exeption(Integer idUsuario) throws UsuarioNoEncontradoException;
	Usuario obtenerPorId_RuntimeExeption1(Integer idUsuario) throws UsuarioNoEncontradoRuntimeException;
	Usuario obtenerPorId_RuntimeExeption2(Integer idUsuario) throws UsuarioNoEncontradoRuntimeException;
	Usuario obtenerPorId_RuntimeExeption3(Integer idUsuario) throws UsuarioNoEncontradoRuntimeException;

	Optional<Usuario> obtenerPorId_Optional(Integer idUsuario);
	Optional<Usuario> findById(Integer idUsuario);
}
