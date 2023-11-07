package com.company.principios.InyeccionDependencia;


public class EquipoBarcelona implements IEquipo{

	@Override
	public String mostrarNombre() {
		return "Barcelona FC";
	}

	@Override
	public String toString() {
		return "EquipoBarcelona [mostrarNombre()=" + mostrarNombre() + "]";
	}
	
}
