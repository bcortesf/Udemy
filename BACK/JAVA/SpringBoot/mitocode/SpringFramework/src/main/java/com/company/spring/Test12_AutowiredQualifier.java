package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans12.Jugador_AutoWiredBQualifier;
import com.company.beans12.Jugador_AutowiredA;

/**
<!--......................................................................................................................................................................................................................................
		19 Anotación @Required(ANTES) ==  ***@Autowired(ACTUAL)***
		   USO:   la anotación required permitirá establecer la necesidad de un valor en un bean manejado en este framework	
			https://www.youtube.com/watch?v=WKtUBC09xpg&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=19
			
		20 Anotación Autowired y Qualifier
		   USO:    las anotaciones @Autowired y @Qualifier, las que te permitirán realizar un seteo de tus propiedades de manera automática
			https://www.youtube.com/watch?v=Li5L1uGTOqM&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=20
...................................................................................................................................................................................................................................... -->
 */
public class Test12_AutowiredQualifier
{
    public static void main( String[] args )
    {
    	System.out.println("test12");

    	Test12_AutowiredQualifier.Beans_Autowired();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test12_AutowiredQualifier.Beans_AutowiredQualifier();
    }

	private static void Beans_Autowired() {
		 System.out.println("\n1. ->Beans_Autowired()	:.");

		 String configLocation = "com/company/xml/bean12_AutowiredA.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	     Jugador_AutowiredA lioMessi = (Jugador_AutowiredA) applicationContext.getBean("BEAN_JugadorMessiID") ;
	     
		 System.out.println(lioMessi);
		 System.out.println(lioMessi.getNombre());
		 System.out.println(lioMessi.getEquipo().mostrarNombre());

	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	private static void Beans_AutowiredQualifier() {
		 System.out.println("\n2. ->Beans_AutowiredQualifier()	:.");

		 String configLocation = "com/company/xml/bean12_AutowiredB_Qualifier.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	     Jugador_AutoWiredBQualifier lioMessi = (Jugador_AutoWiredBQualifier) applicationContext.getBean("BEAN_JugadorMessiID") ;
	     
		 System.out.println(lioMessi);
		 System.out.println(lioMessi.getNombre());
		 System.out.println(lioMessi.getEquipo().mostrarNombre());

	     ((ConfigurableApplicationContext) applicationContext).close();
	}


}
