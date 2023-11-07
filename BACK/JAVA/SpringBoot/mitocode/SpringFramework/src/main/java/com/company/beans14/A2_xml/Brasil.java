package com.company.beans14.A2_xml;

//import com.company.beans14.A1_xml.Equipo;

public class Brasil extends AEquipo implements IEquipo {

	public Brasil() {}
	
	
	///////////////////////////////////////
	//				->CLASE-ABSTRACTA-EQUIPO
	@Override
	public void setId(int id) {
		super.setId(id);
	}
	@Override
	public void setNombre(String nombre) {
		super.setNombre(nombre);
	}

	///////////////////////////////////////
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
	/////////////////////////////////////////

}
