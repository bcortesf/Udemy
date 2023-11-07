package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans.PersonaAO;

/**
<!--......................................................................................................................................................................................................................................
		   11 Autowire
		   USO:   Por medio de esta propiedad se podrá hacer una relación implicita de las dependencias de los beans
		   https://www.youtube.com/watch?v=5gMMYmvJpPE&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=11
...................................................................................................................................................................................................................................... -->
 */
public class Test4_autowired 
{
    public static void main( String[] args )
    {
    	System.out.println("test4");
    	Test4_autowired.listasRestringidas_XML();
    }

	private static void listasRestringidas_XML() {
		 System.out.println("\n1. ->listasRestringidas_XML()");
		 String configLocation = "com/company/xml/bean4_autowired.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	   /*-> Crear una nueva instancia */
//	     Persona persona = (Persona) applicationContext.getBean("BEAN_PersonaID2");        //:referencia tradicional
	     PersonaAO persona = (PersonaAO) applicationContext.getBean("BEAN_PersonaID");          //autowired, automatico
	     

	     String nombreCiudad = persona.getCiudad().getNombre();

	     System.out.println("" + persona);
	     System.out.println("Ciudades:\t" + nombreCiudad);

	     
	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	
    
}
