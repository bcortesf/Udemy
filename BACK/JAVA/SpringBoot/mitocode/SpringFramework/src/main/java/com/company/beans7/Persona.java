package com.company.beans7;




public class Persona {       //A

	private int id;
	private String nombre;
	private Pais pais;           //B
	private Ciudad ciudad;  //C
	
	////////////////////////////////////
	public void initBean() {
		System.out.println(Persona.class.getPackageName() +"\t :Antes de inicializar el Bean[" + Persona.class.getSimpleName() + "]");
	}
	
	public void destroyBean() {
		System.out.println(Persona.class.getPackageName() +"\t : Bean[" + Persona.class.getSimpleName() + "] a punto de ser destruido");
	}
	////////////////////////////////////
	
	public Persona() {
		System.out.print("    A- ejecucion Constructor Persona\n");
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}


	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", ciudad=" + ciudad + "]";
	}

}
