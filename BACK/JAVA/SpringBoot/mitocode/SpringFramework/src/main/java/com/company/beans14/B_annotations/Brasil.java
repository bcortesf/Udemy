package com.company.beans14.B_annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.company.beans14.A2_xml.AEquipo;
import com.company.beans14.A2_xml.IEquipo;


@Component(value = "brasil_por_defecto")
public class Brasil extends AEquipo implements IEquipo {

	public Brasil() {}
	
	
	///////////////////////////////////////////
	//				->CLASE-ABSTRACTA-EQUIPO
	@Value(value = "1")
	@Override
	public void setId(int id) {
		super.setId(id);
	}
	@Value(value = "Brasil")
	@Override
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}

	///////////////////////////////////////////
	//				->INTERFAZ-IEQUIPO
	@Override
	public String mostrarNombre() {
		return "Brasil";
	}
	@Override
	public AEquipo getTeamInstance() {
		return this;
	}
	@Override
	public void setTeamInstance(AEquipo equipo) {
		super.setId(equipo.getId());
		super.setNombre(equipo.getNombre());
	}
	
	///////////////////////////////////////////
	//				->CLASE-OBJECT
	@Override
	public String toString() {
		return "Brasil [" + super.toString() + "]";        //abstract Equipo
	}
	///////////////////////////////////////////

}
