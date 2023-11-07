package com.company.beans3;

import java.util.List;

import com.company.beans.CiudadAO;



public class Pais_Coleccion {
	private String nombre;
	private List<CiudadAO> ciudades;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	// Getter and Setter for the list
	public List<CiudadAO> getCiudades() {
		return ciudades;
	}

	public void setCiudades(List<CiudadAO> ciudades) {
		this.ciudades = ciudades;
	}

	// Method to add an item to the list
	public void addItemToList(CiudadAO item) {
        ciudades.add(item);
    }
    // Method to remove an item from the list
    public void removeItemFromList(CiudadAO item) {
    	ciudades.remove(item);
    }



	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", ciudades=" + ciudades + "]";
	}
	
}
