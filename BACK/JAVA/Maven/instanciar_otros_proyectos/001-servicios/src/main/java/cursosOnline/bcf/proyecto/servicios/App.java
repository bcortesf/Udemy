package cursosOnline.bcf.proyecto.servicios;

import java.time.LocalDate;
import java.util.List;

import cursosOnline.bcf.proyecto.entidades.Persona;
import cursosOnline.bcf.proyecto.servicios.App;
import cursosOnline.bcf.proyecto.servicios.exepciones.ServicioPersonaExepcion;

/**
 * SERVICIOS
 *
 */
public class App 
{
	private static ServicioPersona servicep = new ServicioPersona(); 
	
    public static void main( String[] args )
    {
    	System.out.println("\n" + "*********************************************************************");
        System.out.println("/entidades/src/main/java/cursosOnline/bcf/proyecto/servicios/App.java");
        System.out.println("**Componente  <servicios>**".toUpperCase());
        System.out.println("    => es un utilitario <commons>");
        System.out.println();
        System.out.println("    => Implementara componentes locales compartidos, que se almacenaron en mi repositorio local de MAVEN:");
        System.out.println("       C:\\Users\\BryanCFz\\.m2\\repository\\cursosOnline\\bcf\\proyecto\\entidades\\1.0.0--vers-entidades");
        System.out.println("\t" + "- <Commons>.Entidades");
        System.out.println("*********************************************************************" + "\n");
//
        show();
    }
    public static void show() {
    	//new ServicioPersona().Mostrar();
    	servicep.Crear();
    	try {
			servicep.Insertar(new Persona(2, "pepe", LocalDate.now()));
			servicep.Insertar(new Persona(3, "pipi", LocalDate.now()));
			//servicep.Insertar(new Persona(1, "PAPA", LocalDate.now())); // **LLEGA hasta aqui y para de insertar, ignorando el resto
			servicep.Insertar(new Persona(4, "popo", LocalDate.now()));
			servicep.Insertar(new Persona(5, "pupu", LocalDate.now()));
		} catch (ServicioPersonaExepcion e) {
			System.err.println(e.getMensaje());
			//e.printStackTrace();
		}

    	System.out.println("\n" + "=> MOSTRAR-1");
    	getPersonas( servicep.Mostrar() );

    	System.out.println("\n" + "=> MOSTRAR-2");
    	try {
    		servicep.Eliminar(3);  //-> Eliminar a pipi
		} catch (ServicioPersonaExepcion e) {
			// e.printStackTrace();
			System.err.println(e.getMensaje());
		} 
    	getPersonas( servicep.Mostrar() );
    }
    public static void getPersonas(List<Persona> personas) {
    	for (Persona persona : personas) {
			System.out.println(persona);
		}
    }
}
