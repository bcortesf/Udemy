package cursosOnline.bcf.proyecto.entidades;

import java.time.LocalDate;

/**
 * ENTIDADES
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.println("\n" + "*********************************************************************");
        System.out.println("/entidades/src/main/java/cursosOnline/bcf/proyecto/entidades/App.java");
        System.out.println("**Componente  <entidades>**".toUpperCase());
        System.out.println("    => es un utilitario <commons>");
        System.out.println("*********************************************************************" + "\n");
//
//        show();
    }
    
    public static void show() {
    	Persona persona = new Persona(10, "Bryan", LocalDate.parse("1990-11-10"));
    	System.out.println(persona);
    }
}
