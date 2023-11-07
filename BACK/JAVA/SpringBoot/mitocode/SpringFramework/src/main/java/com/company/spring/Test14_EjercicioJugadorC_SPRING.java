package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.company.beans14.B_annotations.Jugador;
import com.company.beans14.C_spring4.AppConfig;

/**
<!--......................................................................................................................................................................................................................................
		 24 Ejercicio 3 Java Based
		   USO:  En este enfoque veremos como realizar el mismo ejemplo pero solamente utilizando código java, sin depender de archivos de configuración XML.
			https://www.youtube.com/watch?v=T00FyeedYwQ&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=24
...................................................................................................................................................................................................................................... -->
 */
public class Test14_EjercicioJugadorC_SPRING
{
    public static void main( String[] args )
    {
    	System.out.println("Test14_EjercicioJugadorC_SPRING");

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorC_SPRING.Beans_SPRING_AUTOMATIC();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    }


	private static void Beans_SPRING_AUTOMATIC() {
		 System.out.println("\n3. ->Beans_SPRING_AUTOMATIC()	:.");

		 ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
	     
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     ronaldiño.getCamiseta().getMarca().setNombre("ULTIMA-LINEA :3");
	     System.out.println(ronaldiño);

	     //	
	     System.out.println("\n");
	     System.out.println("equipo.nombre  :" + ronaldiño.getEquipo().getTeamInstance().getNombre());
	     System.out.println(ronaldiño);
	     
	     //
	     ronaldiño.getEquipo().getTeamInstance().setNombre("Garottos-club");
	     System.out.println("\nequipo.Mostrar()  :" + ronaldiño.getEquipo().mostrarNombre());                   //"Brasil"
	     System.out.println("equipo.nombre  :" + ronaldiño.getEquipo().getTeamInstance().getNombre()); //"Garottos-club"
	     System.out.println(ronaldiño);
	     
	     ((ConfigurableApplicationContext) applicationContext).close();
	}

}
