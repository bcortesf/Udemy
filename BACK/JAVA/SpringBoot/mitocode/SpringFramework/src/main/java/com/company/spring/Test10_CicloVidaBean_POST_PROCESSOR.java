package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans.CiudadAO;
import com.company.beans.PersonaAO;

/**
<!--......................................................................................................................................................................................................................................
		17 BeanPostProcessor
		   USO:   el uso de una clase beanPostProcessor para manejar los eventos antes y después de la inicialización de un bean por medio del core container.
			https://www.youtube.com/watch?v=zNF-BClQdFU&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=17
...................................................................................................................................................................................................................................... -->
 */
public class Test10_CicloVidaBean_POST_PROCESSOR
{
    public static void main( String[] args )
    {
    	System.out.println("test10");
    	Test10_CicloVidaBean_POST_PROCESSOR.cicloDeVida_INTERFACES();
    }

	private static void cicloDeVida_INTERFACES() {
		 System.out.println("\n1. ->cicloDeVida_POST_PROCESSOR()");
		 
//		 System.out.println("--------------------------------------------------------------------------------------------------");
		 Beans();
	}

	
	private static void Beans() {
		System.out.println("\n1.2. ->Beans()	:Se crea clase processor para los beans");

		String configLocation = "com/company/xml/bean10_PostProcessor_BeanAfterBefore_Initializacion.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	   //:S
	     PersonaAO persona   = (PersonaAO) applicationContext.getBean("BEAN_PersonaID"); //A
//	     Pais pais               = (Pais) applicationContext.getBean("pais");                            //B
	     CiudadAO ciudad       = (CiudadAO) applicationContext.getBean("ciudad");                   //C
	     
	     
	     System.out.println("    A- " + persona);
//	     System.out.println("    B- " + pais);
		 System.out.println("    C- " + ciudad);
		 


	     ((ConfigurableApplicationContext) applicationContext).close();
	}

}
