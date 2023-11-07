package com.company.beans13;

import org.springframework.stereotype.Component;

import com.company.principios.InyeccionDependencia.IEquipo;

@Component
public class EquipoJuventus_Component implements IEquipo{

    @Override
    public String mostrarNombre() {
    	return "Juventus";
    }

}
