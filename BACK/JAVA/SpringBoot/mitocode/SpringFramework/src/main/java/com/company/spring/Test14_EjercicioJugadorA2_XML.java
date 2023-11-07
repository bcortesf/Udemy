package com.company.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans14.A2_xml.AEquipo;
import com.company.beans14.A2_xml.Brasil;
import com.company.beans14.A2_xml.EquipoBarcelona;
import com.company.beans14.A2_xml.EquipoJuventus;
import com.company.beans14.A2_xml.IEquipo;
import com.company.beans14.A2_xml.Jugador;

/**
<!--......................................................................................................................................................................................................................................
		22 Ejercicio 1 XML
		   USO:  Ejercicio donde se resumirá gran parte de los tutoriales usando el enfoque XML.
			https://www.youtube.com/watch?v=DJc2nq4_fPk&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=22
		
		Se implementa  interfaces en EquipoBarcelona por IEquipo
...................................................................................................................................................................................................................................... -->
 */
public class Test14_EjercicioJugadorA2_XML
{
    public static void main( String[] args )
    {
    	System.out.println("Test14_EjercicioJugadorA2_XML");

//    	/////////////////////////////////////////////////////
//    	Test14_Ejercicio_XML.lecturaConsola();
//    	Test14_Ejercicio_XML.lecturaConsolaDinamica();
//    	/////////////////////////////////////////////////////


    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorA2_XML.Beans_XML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorA2_XML.Beans_Teclado_XML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

    }


	private static void Beans_XML() {
		 System.out.println("\n1.1. ->Beans_XML()	:.");

		 String configLocation = "com/company/xml/bean14_JugadorA2_XML.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     System.out.println(ronaldiño);	     

	     ((ConfigurableApplicationContext) applicationContext).close();
	}



	private static void Beans_Teclado_XML() {
		 System.out.println("\n1.2. ->Beans_Teclado_XML()	:.");

		 String configLocation = "com/company/xml/bean14_JugadorA2_XML.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     Brasil brasil = (Brasil) applicationContext.getBean("BEAN_BrasilID");
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     ronaldiño = Test14_EjercicioJugadorA2_XML.cambiarEquipo(ronaldiño, brasil);
	     System.out.println(ronaldiño);	     

	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	private static Jugador cambiarEquipo(Jugador jugador, Brasil brasil) { //Cambio de Brasil, por interfaz IPais
    	Scanner in = new Scanner(System.in);
    	int numeroEquipo = 0;
        String esCambioDeEquipo = "N";
        String formatoEquipos = 
        """
        1. Barcelona
        2.Juventus
        ¿Ingrese numero del equipo?  :
		""";

        System.out.println("Equipo Actual :" + jugador.getEquipo().mostrarNombre() + "\n");  //interface IEquipo
        //----------------------------------------------------------------------------------
//        							COMENTARIADO-TEMPORALMENTE
        /*System.out.print("\t¿Quiere cambiar de equipo? Y,N  :");
        esCambioDeEquipo = in.next();
        in.nextLine(); //consumiendo el <enter> de la entrada anterior*/
      //----------------------------------------------------------------------------------
        esCambioDeEquipo = "NO";

        if (esCambioDeEquipo.startsWith("Y")  || esCambioDeEquipo.startsWith("y") ) {
        	System.out.print(formatoEquipos);  //->equipos-disponibles
        	numeroEquipo = in.nextInt();

        	@SuppressWarnings("resource")
			IEquipo equipoCambiado = switch (numeroEquipo) {
				case 1 -> new EquipoBarcelona();
				case 2 -> new EquipoJuventus();
				default -> throw new IllegalArgumentException("Unexpected value: " + numeroEquipo);
        	};

        	jugador = Test14_EjercicioJugadorA2_XML.setEquipo(jugador, equipoCambiado);
        	in.nextLine(); //consumiendo el <enter> de la entrada anterior
		}
        else {
        	//----------------------------------------------------------------------------------------------------------------
        	//Solo para Demostracion, uso del objBrasil
        	                                                                                                                      //Equipo
        	System.out.println("Brasil[HIJO].instancia.Equipo[PADRE] = " + brasil.getTeamInstance());
        	//System.out.println("Brasil.nombre = " + brasil.getNombre());
        	//----------------------------------------------------------------------------------------------------------------
        	
        	/* OPCION #1: 								IEquipo(Equipo) ~~ Interfaz(ClaseConcreta) */
//        	jugador.setEquipo(brasil);
        	
        	/* OPCION #2:									 IEquipo(IEquipo) ~~ Interfaz(Interfaz) */
//        	IEquipo iequipo = brasil;
//        	jugador.setEquipo(iequipo);

        	/* OPCION #3:									 AEquipo(AEquipo) ~~ Abstracta(ClaseConcreta) */
//        	AEquipo equipoAbtracto = brasil.getTeamInstance();
//        	IEquipo iequipo = (IEquipo) equipoAbtracto;
//        	jugador.setEquipo(iequipo);
        	

        	/* OPCION #4 									Cambiar valores a Brasil*/
//        	brasil.getTeamInstance().setId(77);
//        	brasil.getTeamInstance().setNombre("Brazilian");
//        	jugador.setEquipo(brasil);
        	
        	/* OPCION #5 									Cambiar valores a Brasil*/
//        	AEquipo aequipo = brasil.getTeamInstance();
//        		aequipo.setId(88);
//        		aequipo.setNombre("Colombina");
//        	IEquipo iequipo = (IEquipo) aequipo;
//        	jugador.setEquipo(iequipo);


        	/* OPCION #6 									Cambiar valores a Brasil, porque es SINGLETON, USA MISMA INSTANCIA*/
        	AEquipo aequipo = brasil;
        	aequipo.setId(99);
        	aequipo.setNombre("Coli");
        	jugador.setEquipo(brasil);
        	
        	System.out.println("");
																	 //IEquipo  .         Equipo 
			System.out.println("id:" + jugador.getEquipo().getTeamInstance().getId() );                   //Equipo
			System.out.println("nombre:" + jugador.getEquipo().getTeamInstance().getNombre());//Equipo
        	
        }

        in.close(); 
		return jugador;
	}
	private static Jugador setEquipo(Jugador jugador, IEquipo equipoCambiado) {
		jugador.setEquipo(equipoCambiado);
		return jugador;
	}


}
