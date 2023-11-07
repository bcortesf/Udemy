package cursosOnline.bcf.proyecto.entidades;

import java.time.LocalDate;

public record Persona(int cedula , String nombre, LocalDate fechaNacimiento) {
	// ALT + SHIF + S		:Source
	
	public int cedula() {
		return cedula;
	}

	public String nombre() {
		return nombre;
	}

	public LocalDate fechaNacimiento() {
		return fechaNacimiento;
	}

	
	public String get_CedulaNombre() {
		return "- Persona [cedula=" + cedula + ", nombre=" + nombre + "]";
	}
	
	
}
