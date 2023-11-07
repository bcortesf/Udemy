package com.company.beans14.A2_xml;

public class EquipoJuventus extends AEquipo implements IEquipo {

	public EquipoJuventus() {
		super.setId(2023);
		super.setNombre("JujuVen");
	}

	///////////////////////////////////////
	//				->INTERFAZ-IEQUIPO
	@Override
	public String mostrarNombre() {
		return "Juventus";
	}
	@Override
	public AEquipo getTeamInstance() {
		return this;
	}
	@Override
	public void setTeamInstance(AEquipo equipo) {
		// TODO Programado en beans14/A2_xml/Brasil.java
	}

	///////////////////////////////////////////
	//				->CLASE-OBJECT
	@Override
	public String toString() {
//		return "EquipoBarcelona [this.mostrarNombre()=" + this.mostrarNombre() + "]"; //interface IEquipo
		
		return "EQ.EquipoJuventus [EQ-PADRE=" + super.toString()     + "]";        //abstract Equipo
//		return  "EQ.EquipoJuventus [EQ-PADRE=" + this.mostrarNombre() + "]"; //abstract IEquipo
	}
	/////////////////////////////////////////

}
