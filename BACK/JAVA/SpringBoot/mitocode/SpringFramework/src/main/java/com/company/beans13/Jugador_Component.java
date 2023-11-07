package com.company.beans13;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.company.principios.InyeccionDependencia.IEquipo;

@Component    //<--ES-IGUAL-A-->    @Component(value = "jugador_Component")
public class Jugador_Component {
	
	//ATRIBUTO
	private int numero;
	@Value(value = "Lionel Messi")
	private String nombre;
	
	@Autowired(required = true)    //  <=IGUALES=>  @Required
	@Qualifier("QUALIFIER_EquipoBarcelonaVALUE")     //LLamar por [QUALIFIER.VALUE]
	private IEquipo equipo;
	

	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public IEquipo getEquipo() {
		return equipo;
	}
	public void setEquipo(IEquipo equipo) {
		this.equipo = equipo;
	}
	
	@Override
	public String toString() {
		return "Jugador [numero=" + numero + ", nombre=" + nombre + ", equipo=" + equipo + "]";
	}
	
}
