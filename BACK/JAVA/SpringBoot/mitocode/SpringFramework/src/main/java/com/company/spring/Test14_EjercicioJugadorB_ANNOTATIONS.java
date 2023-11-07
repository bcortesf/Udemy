package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans14.B_annotations.Jugador;

/**
<!--......................................................................................................................................................................................................................................
		23 Ejercicio 2 Anotaciones
		   USO:  Continuaremos con el desarrollo del ejemplo pero cambiando el enfoque a anotaciones
			https://www.youtube.com/watch?v=RpKBt1mrgKY&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=23
			
			https://docs.spring.io/spring-framework/docs/4.3.x/spring-framework-reference/html/xsd-configuration.html#xsd-config-body-schemas-context
...................................................................................................................................................................................................................................... -->
 */
public class Test14_EjercicioJugadorB_ANNOTATIONS
{
    public static void main( String[] args )
    {
    	System.out.println("Test14_EjercicioJugadorB_ANNOTATIONS");

    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test14_EjercicioJugadorB_ANNOTATIONS.Beans_ANNOTATIONS();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");

    }

	private static void Beans_ANNOTATIONS() {
		 System.out.println("\n2. ->Beans_ANNOTATIONS()	:.");

		 String configLocation = "com/company/xml/bean14_JugadorB_ANNOTATIONS.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     Jugador ronaldiño = (Jugador) applicationContext.getBean("BEAN_JugadorID");
	     ronaldiño.getCamiseta().getMarca().setNombre("ULTIMA-LINEA :3");
	     System.out.println(ronaldiño);

	     //
	     System.out.println("\n");
	     System.out.println("equipo.nombre  :" + ronaldiño.getEquipo().getTeamInstance().getNombre());
	     System.out.println(ronaldiño);
	     
	     //
	     ronaldiño.getEquipo().getTeamInstance().setNombre("Garottos-club");
	     System.out.println("\nequipo.nombre  :" + ronaldiño.getEquipo().getTeamInstance().getNombre());
	     System.out.println(ronaldiño);
	     
	     ((ConfigurableApplicationContext) applicationContext).close();
	}

}
