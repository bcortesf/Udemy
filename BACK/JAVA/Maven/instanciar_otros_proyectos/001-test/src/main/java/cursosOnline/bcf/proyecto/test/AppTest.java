package cursosOnline.bcf.proyecto.test;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cursosOnline.bcf.proyecto.entidades.Persona;
import cursosOnline.bcf.proyecto.servicios.ServicioPersona;
import cursosOnline.bcf.proyecto.servicios.exepciones.ServicioPersonaExepcion;
import cursosOnline.bcf.proyecto.test.AppTest;

/**
 * TEST
 *
 */
public class AppTest 
{
	private static ServicioPersona servicio;
	private static Logger LOGGER = LogManager.getLogger(AppTest.class);
	
    public static void main( String[] args )
    {
    	System.out.println("\n" + "****************************************************************************");
        System.out.println("/entidades/src/main/java/cursosOnline/bcf/proyecto/test/App.java");
        System.out.println("**Componente  <test>**".toUpperCase());
        System.out.println("\t=> este implementara componentes locales compartidos ".toUpperCase());
        System.out.println("\t" + "+ <Commons>.Servicios");
        System.out.println("\t" + "- <Commons>.Servicios".concat(" llamara al <Commons>.Entidades"));
        System.out.println("****************************************************************************" + "\n");
        //
        show();
    }
    
    public static void show() {
    	try {
    		servicio = new ServicioPersona();
    		servicio.Crear();
	    	try {
				servicio.Insertar(new Persona(1013, "Bryan"      , LocalDate.parse("2023-08-12")));
				//servicio.Insertar(new Persona(1013, "Bryan copy" , LocalDate.parse("2023-08-12"))); //->No lo inserta y por excepciones ejecuta hasta aqui
				servicio.Insertar(new Persona(1014, "Moticas :'(", LocalDate.parse("2006-01-09")));
		    	servicio.Insertar(new Persona(1015, "shushi"     , LocalDate.parse("2013-12-13")));
			} catch (ServicioPersonaExepcion e) {
				// e.printStackTrace();
				e.getMessage();
			}
	
	    	System.out.println("\t\n" + "=> MOSTRAR PERSONAS-1");
	    	ObtenerPersonas( servicio.Mostrar() );
	    	
	    	System.out.println("\t\n" + "=> BUSCAR PERSONA");
	    	System.out.println(servicio.Buscar(101));
	    	System.out.println(servicio.Buscar(1013));
	    	
	    	System.out.println("\t\n" + "=> MOSTRAR PERSONAS-2");
	    	try {
				servicio.Eliminar(1014);
			} catch (ServicioPersonaExepcion e) {
				// e.printStackTrace();
				System.err.println(e.getMensaje());
			}
	    	ObtenerPersonas( servicio.Mostrar() );


    	} catch (Exception e) {
			System.err.print("Se ha producido un error en el sistema"); //->MENSAJE PARA <CLIENTE>, EN LA APP
			
			//->MENSAJE PARA EL <PROGRAMADOR>, SEPA LA CAUSA DEL CODIGO DE LA EXEPCION JAVA
			LOGGER.error("ERROR: en el sistema por ->", e); //-> e ES IGUAL e.printStackTrace();
		}
    }
    
    public static void ObtenerPersonas(List<Persona> personas) {
    	personas.forEach((Persona persona) -> System.out.println(persona)); //->toString()
		
    }
}


