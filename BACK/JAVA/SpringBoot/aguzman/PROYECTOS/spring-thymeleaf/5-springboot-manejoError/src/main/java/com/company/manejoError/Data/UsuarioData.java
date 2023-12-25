package com.company.manejoError.Data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.manejoError.domainEntityPojo.Usuario;

@Component
public class UsuarioData {
	private List<Usuario> lista;

	public UsuarioData() {}


	public List<Usuario> getLista() {
		this.lista = Arrays.asList(
			new Usuario(1, "Nanita", "Mora"),
			new Usuario(2, "Mamita", "Fern"),
			new Usuario(3, "Minnie", "Cort"),
			new Usuario(4, "Shushi", "cort")
		);
		return lista;
	}
}
