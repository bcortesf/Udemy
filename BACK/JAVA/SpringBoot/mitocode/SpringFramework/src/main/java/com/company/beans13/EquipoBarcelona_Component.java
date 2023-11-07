package com.company.beans13;

import org.springframework.stereotype.Component;

import com.company.principios.InyeccionDependencia.IEquipo;

@Component
public class EquipoBarcelona_Component implements IEquipo{

	@Override
	public String mostrarNombre() {
		return "Barcelona FC";
	}

	@Override
	public String toString() {
		return "EquipoBarcelona [mostrarNombre()=" + mostrarNombre() + "]";
	}
	
}
