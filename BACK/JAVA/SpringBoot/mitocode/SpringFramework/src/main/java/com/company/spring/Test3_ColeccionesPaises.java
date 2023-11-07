package com.company.spring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans.CiudadAO;
import com.company.beans3.Persona_Coleccion;

/**
<!--......................................................................................................................................................................................................................................
		https://chat.openai.com/c/7ca76a4c-1703-4c07-a3f7-9333a9cd62b3

		10 Colecciones
		   USO:   como poder inicializar las colecciones (listas) en spring framework
		   https://www.youtube.com/watch?v=Vwjwyvd1LTI&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=10
...................................................................................................................................................................................................................................... -->
 */
public class Test3_ColeccionesPaises 
{
    public static void main( String[] args )
    {
    	System.out.println("test3");
    	Test3_ColeccionesPaises.listasRestringidas_XML();
    	Test3_ColeccionesPaises.listasInfinitas_XML();
    }

	private static void listasRestringidas_XML() {
		 System.out.println("\n1. ->listasRestringidas_XML()");
		 String configLocation = "com/company/xml/bean3_PaisColeccion.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	   /*-> Crear una nueva instancia */
	     Persona_Coleccion persona = (Persona_Coleccion) applicationContext.getBean("BEAN_PersonaID");                 //[Bean].id
	     
	     String nombreCiudades2 = persona.getPais().getCiudades().toString();
	     List<String> nombreCiudades = persona.getPais().getCiudades().stream()
	    		 .map( (CiudadAO c) -> c.getNombre())
	    		 .toList();

	     System.out.println("" + persona);
	     System.out.println("\ntoString:\t" + nombreCiudades2);
	     System.out.println("jdk8:\t" + nombreCiudades);

	     
	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	
	private static void listasInfinitas_XML() {
		 System.out.println("\n\n2. ->listasInfinitas_XML()");
		 String configLocation = "com/company/xml/bean3_PaisColeccion.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	   /*-> Crear una nueva instancia */
	     Persona_Coleccion persona = (Persona_Coleccion) applicationContext.getBean("BEAN_PersonaID2");                 //[Bean].id
	     
	     CiudadAO ciudad1 = new CiudadAO();
	     CiudadAO ciudad2 = new CiudadAO();
	     ciudad1.setNombre("Texas"); 
	     ciudad2.setNombre("Florida");
	     persona.getPais().getCiudades().add(ciudad1);
	     persona.getPais().getCiudades().add(ciudad2);

	     List<String> nombreCiudades = persona.getPais().getCiudades().stream()
	    		 .map( (CiudadAO c) -> c.getNombre())
	    		 .toList();

	     System.out.println("" + persona);
	     System.out.println("jdk8:\t" + nombreCiudades);

	     
	     ((ConfigurableApplicationContext) applicationContext).close();
	}	
    
}
