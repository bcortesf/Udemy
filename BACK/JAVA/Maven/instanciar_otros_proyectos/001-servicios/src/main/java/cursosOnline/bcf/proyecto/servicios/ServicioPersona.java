package cursosOnline.bcf.proyecto.servicios;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cursosOnline.bcf.proyecto.entidades.Persona;
import cursosOnline.bcf.proyecto.servicios.exepciones.ServicioPersonaExepcion;

public class ServicioPersona {

	//
	private List<Persona> personas;
	
	public ServicioPersona() {
		personas = new ArrayList<>();
	}
	
	public void Crear() {
		personas.add(new Persona(1, "papa", LocalDate.now()));
		System.out.println("Persona creada...	:".concat(this.personas.get(0).get_CedulaNombre()) );
	}


	public void ValidarInsercionPersona(Persona persona) throws ServicioPersonaExepcion {
		if ( Buscar(persona.cedula()) != null ) { 
//			System.err.println("Ya existe en la base de datos".toUpperCase());
//			System.err.println("    ID: persona[cedula=" + persona.cedula() + ", nombre=" + persona.nombre() + "]");
			
			String titulo      = "Ya existe en la base de datos".toUpperCase();
			String descripcion = "    - ID: persona[cedula=" + persona.cedula() + ", nombre=" + persona.nombre() + "]";
			String mensaje = MessageFormat.format("=> {0} \n {1}. \n", titulo, descripcion);
			throw new ServicioPersonaExepcion(mensaje);
		}
	}
	public void Insertar(Persona persona) throws ServicioPersonaExepcion {		
		//if ( Buscar(persona.cedula()) == null ) { }
		//System.out.println("insertamos:  Persona[cedula=" + persona.cedula() + "]");
		ValidarInsercionPersona(persona);
		System.out.println("insertamos:  ".concat(persona.get_CedulaNombre()));
		personas.add(persona);
		
	}
	public Persona Buscar(int cedula) {
		 Persona personaEncontrada = this.personas.stream()
			.filter((Persona persona) -> persona.cedula() == cedula)
			.findAny()
			.orElse(null);
		return personaEncontrada;
	}
	public void Eliminar(int cedula) throws ServicioPersonaExepcion {
		Persona persona = Buscar(cedula);
		if (persona == null) {
			throw new ServicioPersonaExepcion("La Persona[Cedula=" + cedula +"]. No existe, por esta razon no se puede eliminar");
		}
		this.personas.remove(persona);
		System.out.println("\t==> Eliminamos a ".concat(persona.get_CedulaNombre().concat("\n")));
	}
	public List<Persona> Mostrar() {
		if (this.personas.isEmpty()) {
			System.out.println("No hay personas almacenadas en la base de datos.");
		}
		return this.personas;
//		if (!this.personas.isEmpty()) {
//			personas.forEach((Persona persona) -> System.out.println(persona)); //->toString()
//		}
	}
	
}
