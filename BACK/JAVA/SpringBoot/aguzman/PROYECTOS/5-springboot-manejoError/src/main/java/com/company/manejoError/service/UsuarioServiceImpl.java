package com.company.manejoError.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.manejoError.Data.UsuarioData;
import com.company.manejoError.Exceptions.UsuarioNoEncontradoException;
import com.company.manejoError.Exceptions.UsuarioNoEncontradoRuntimeException;
import com.company.manejoError.domainEntityPojo.Usuario;

@Repository
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private UsuarioData usuarioData;

	@Override
	public List<Usuario> listar() {
		return usuarioData.getLista();
	}

	@Override
	public Usuario obtenerPorId_Exeption(Integer idUsuario) throws UsuarioNoEncontradoException {
		try {
			Usuario usuario = this.usuarioData.getLista().stream()
					.filter((Usuario u) -> u.getId().equals(idUsuario))
					.findFirst()
					.get();
			return usuario;
		} catch (Exception e) {
			throw new UsuarioNoEncontradoException(
				"No se encontro el usuario con ID<".concat(idUsuario.toString()).concat(">")
				, idUsuario);
		}
	}


	@Override
	public Usuario obtenerPorId_RuntimeExeption1(Integer idUsuario) {  //: throws UsuarioNoEncontradoRuntimeException
		Usuario usuario = null;
		for (Usuario user : this.usuarioData.getLista()) {
			if (user.getId().equals(idUsuario)) {
				usuario = user;
				break;
			}
		}
		System.err.println("FIN DE BUSCAR-1");
		return usuario;
	}


	@Override
	public Usuario obtenerPorId_RuntimeExeption2(Integer idUsuario) {  //: throws UsuarioNoEncontradoRuntimeException
		Usuario usuario = null;
		for (Usuario user : this.usuarioData.getLista()) {
			if (user.getId().equals(idUsuario)) {
				usuario = user;
				break;
			}
		}
		/*******OPCION#2:	VALIDACION POR -> CAPA-SERVICE*******/		
		if (usuario == null) {
			throw new UsuarioNoEncontradoRuntimeException(
					"No se encontro el usuario con ID<<".concat(String.valueOf(idUsuario)).concat(">>")
					,idUsuario	
			);
		}
		System.err.println("FIN DE BUSCAR-2");
		return usuario;
	}


	@Override
	public Usuario obtenerPorId_RuntimeExeption3(Integer idUsuario) {  //: throws UsuarioNoEncontradoRuntimeException
		Usuario usuario = this.usuarioData.getLista().stream()
				.filter((Usuario u) -> u.getId().equals(idUsuario)) //type      : <Optional>
				.map((Usuario u)  -> u)                             //convertTo-> <Usuario>
				.findFirst()
				.orElseThrow(() -> new UsuarioNoEncontradoRuntimeException(
						/*******OPCION#3:	VALIDACION POR -> CAPA-SERVICE*******/	
						"No se encontro el usuario con ID<<<".concat(idUsuario.toString()).concat(">>>")
						, idUsuario));
		System.err.println("FIN DE BUSCAR-3");
		return usuario;
	}
	
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public Optional<Usuario> obtenerPorId_Optional(Integer idUsuario) {  //: throws UsuarioNoEncontradoRuntimeException
		Usuario usuario = obtenerPorId_RuntimeExeption1(idUsuario);
		System.err.println("FIN DE BUSCAR-4");
		return Optional.ofNullable(usuario);
	}
	@Override
	public Optional<Usuario> findById(Integer idUsuario) {
		return this.usuarioData.getLista().stream()
			.filter((Usuario u) -> u.getId().equals(idUsuario))
			.findFirst();
	}

}