package com.company.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans14.A1_xml.Equipo;
import com.company.beans14.A1_xml.Jugador;

/**
<!--......................................................................................................................................................................................................................................
		22 Ejercicio 1 XML
		   USO:  Ejercicio donde se resumirá gran parte de los tutoriales usando el enfoque XML.
			https://www.youtube.com/watch?v=DJc2nq4_fPk&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=22
		
		Solo clases java
		No se usa interfaces
...................................................................................................................................................................................................................................... -->
 */
public class Test14_EjercicioJugadorA1_XML
{
    public static void main( String[] args )
    {
    	System.out.println("Test14_EjercicioJugadorA1_XML");

//    	/////////////////////////////////////////////////////
//    	Test14_Ejercicio_XML.lecturaConsola();
//    	Test14_Ejercicio_XML.lecturaConsolaDinamica();
//    	/////////////////////////////////////////////////////


    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorA1_XML.Beans_XML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorA1_XML.Beans_Teclado_XML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

    }


	private static void Beans_XML() {
		 System.out.println("\n1.1. ->Beans_XML()	:.");

		 String configLocation = "com/company/xml/bean14_JugadorA1_XML.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     System.out.println(ronaldiño);	     

	     ((ConfigurableApplicationContext) applicationContext).close();
	}



	private static void Beans_Teclado_XML() {
		 System.out.println("\n1.2. ->Beans_Teclado_XML()	:.");

		 String configLocation = "com/company/xml/bean14_JugadorA1_XML.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     ronaldiño = Test14_EjercicioJugadorA1_XML.cambiarEquipo(ronaldiño);
	     System.out.println(ronaldiño);	     

	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	private static Jugador cambiarEquipo(Jugador jugador) {
    	Scanner in = new Scanner(System.in); 
        String nombreEquipo         = "";
        String esCambioDeEquipo = "N";
        
        System.out.println("Equipo Actual :" + jugador.getEquipo().getNombre());
        System.out.print("\t¿Quiere cambiar de equipo? Y,N  :");
        esCambioDeEquipo = in.next();
        in.nextLine(); //consumiendo el <enter> de la entrada anterior
        
        while (esCambioDeEquipo.startsWith("Y")  || esCambioDeEquipo.startsWith("y") ) {
        	System.out.print("¿Ingrese nombre del equipo  :");  
        	nombreEquipo = in.next();

        	jugador = Test14_EjercicioJugadorA1_XML.setEquipo(jugador, nombreEquipo);
        	in.nextLine(); //consumiendo el <enter> de la entrada anterior
        	
        	System.out.print("\t¿Quiere cambiar de equipo? Y,N  :");
            esCambioDeEquipo = in.next();
            in.nextLine(); //consumiendo el <enter> de la entrada anterior
		}
        in.close(); 

		return jugador;
	}
	private static Jugador setEquipo(Jugador jugador, String nombreEquipoCambiado) {
		//jugador.getEquipo().setId(2);
		//jugador.getEquipo().setNombre("Barcelona FC");
		
		Equipo equipo = jugador.getEquipo();
		equipo.setId(equipo.getId()+1);
		equipo.setNombre(nombreEquipoCambiado);
		jugador.setEquipo(equipo);
		return jugador;
	}


	//___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
	//___________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________
    @SuppressWarnings("unused")
	private static void lecturaConsola() {
    	// https://www.google.com/search?q=java+scanner+multiple+inputs&oq=java+scanner+mul&gs_lcrp=EgZjaHJvbWUqCQgAEAAYExiABDIJCAAQABgTGIAEMgkIARAAGBMYgAQyBggCEEUYOTIJCAMQABgTGIAEMgoIBBAAGBMYFhgeMgoIBRAAGBMYFhgeMgoIBhAAGBMYFhgeMgoIBxAAGBMYFhgeMgoICBAAGBMYFhgeMgoICRAAGBMYFhgeqAIAsAIA&sourceid=chrome&ie=UTF-8&bshm=rimc/1
    	// https://www.javatpoint.com/how-to-take-multiple-string-input-in-java-using-scanner
    	Scanner in = new Scanner(System.in); 
    	
        System.out.print("¿Cedula?: ");  
        int cedula = in.nextInt();
        in.nextLine(); //consumiendo el <enter> de la entrada anterior
        System.out.println("\n¿Nombre?: ");  
        String nombre = in.nextLine();
        
        System.out.println("Cedula es: " + cedula);
        System.out.println("Nombre es: " + nombre);
        
        in.close();  
    }
    @SuppressWarnings("unused")
    private static void lecturaConsolaDinamica() {
    	Scanner in = new Scanner(System.in); 
    	
        String nombreEquipo         = "";
        String esCambioDeEquipo = "";
        do {
        	System.out.print("¿Ingrese nombre del equipo  :");  
        	nombreEquipo = in.next();
        	System.out.println("nombreEquipo: " + nombreEquipo);
        	in.nextLine(); //consumiendo el <enter> de la entrada anterior
        	
        	System.out.print("\t¿Quiere cambiar de equipo? Y,N  :");
            esCambioDeEquipo = in.next();
		} while (esCambioDeEquipo.startsWith("Y")  || esCambioDeEquipo.startsWith("y") );
        System.out.println("sale");

        in.close();  
    }

}
