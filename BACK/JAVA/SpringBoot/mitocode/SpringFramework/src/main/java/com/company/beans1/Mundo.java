package com.company.beans1;

import org.springframework.beans.factory.annotation.Value;

public class Mundo {

	@Value(value = "hola Bryan; clase<Mundo>-var{saludo@value}, sino te defino un valor, serias null")
	private String saludo;

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}
	
}
