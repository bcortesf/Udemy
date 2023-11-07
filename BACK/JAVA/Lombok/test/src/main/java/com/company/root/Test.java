package com.company.root;

import java.time.LocalDate;

import com.company.root.model.Persona;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hola Bry");
		Persona persona = new Persona();
		persona.setDni("1013");
		persona.setFechaNacimiento(LocalDate.parse("2023-06-26"));
		persona.setNombre("Bryan");
		persona.setPais("Colombia");
		
		System.out.println(persona.toString());
	}

}
