package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans7.Ciudad;
import com.company.beans7.Pais;
import com.company.beans7.Persona;

/**
<!--......................................................................................................................................................................................................................................
		14 Ciclo de Vida de los Beans
		   USO:   como poder invocar acciones antes de la inicialización y destrucciones de los beans manejados por spring.
			https://www.youtube.com/watch?v=6DJX7uf7WF8&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=14
...................................................................................................................................................................................................................................... -->
 */
public class Test7_CicloVidaBean_XML
{
    public static void main( String[] args )
    {
    	System.out.println("test7");
    	Test7_CicloVidaBean_XML.cicloDeVida_XML();
    }

	private static void cicloDeVida_XML() {
		 System.out.println("\n1. ->cicloDeVida_XML()");
		 
		 BeanConcreto();
		 System.out.println("--------------------------------------------------------------------------------------------------");
		 BeansGenerales();
	}


	private static void BeanConcreto() {
		System.out.println("\n1.1. ->BeanConcreto()	:solo se declara en el <bean> especifico");
		String configLocation = "com/company/xml/bean7_CicloDeVida_BeanConcreto.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	   //:S
	     Persona persona   = (Persona) applicationContext.getBean("BEAN_PersonaID");
	     
		 System.out.println("    B- " + persona.getNombre()); 


	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	
	private static void BeansGenerales() {
		System.out.println("\n1.2. ->BeansGenerales()	:se declara a nivel general para todos los <beans>");
		System.out.println("CONSTRUCTORES");
		System.out.println("* Construir primero  'Bean<PADRE>' y segun fueron declaradas las [propiedades.privadas] de este;  Construira en  orden  DESCENDENTE a los  'Beans<HIJOS>'");
		System.out.println("CICLO_DE_VIDA_BEAN, por metodo.init(), metodo.destroy");
		System.out.println("+ Inicializar los  'Beans<HIJOS>'  internos; su orden sera DESCENDENTE, segun fueron declaradas las [propiedades.privadas] en el  'Bean<PADRE>'");
		System.out.println("+ Destruir el 'Bean<PADRE>' y despues los  'Beans<HIJOS>';  segun fueron declarados en la clase.PADRE   #   o llamados  desde el getBEan"+"\n\n");

		String configLocation = "com/company/xml/bean7_CicloDeVida_BeansGenerales.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	   //:S
	     Persona persona   = (Persona) applicationContext.getBean("BEAN_PersonaID"); //A
	     
//	     Pais pais               = (Pais) applicationContext.getBean("pais");                            //B
	     
	     Ciudad ciudad       = (Ciudad) applicationContext.getBean("ciudad");                   //C
	     Pais pais               = (Pais) applicationContext.getBean("pais");                            //B
	     
	     
	     System.out.println("    A- " + persona);
	     System.out.println("    B- " + pais);
		 System.out.println("    C- " + ciudad);
		 


	     ((ConfigurableApplicationContext) applicationContext).close();
	}

}
