package com.company.root.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Persona {
	private String dni;
	private LocalDate fechaNacimiento;
	private String nombre;
	private String pais;
}
