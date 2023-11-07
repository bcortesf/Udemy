package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans9.Ciudad;
import com.company.beans9.Pais;
import com.company.beans9.Persona;

/**
<!--......................................................................................................................................................................................................................................
		16 Ciclo de Vida de los Beans (Interfaces)	
		   USO:   Otra manera de controlar los eventos después de la inicialización de un bean y antes de su destrucción es mediante el uso de las interfaces InitializingBean y DisposableBean
			https://www.youtube.com/watch?v=6Ja2WgTqfm0&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=16
...................................................................................................................................................................................................................................... -->
 */
public class Test9_CicloVidaBean_INTERFACES
{
    public static void main( String[] args )
    {
    	System.out.println("test9");
    	Test9_CicloVidaBean_INTERFACES.cicloDeVida_INTERFACES();
    }

	private static void cicloDeVida_INTERFACES() {
		 System.out.println("\n1. ->cicloDeVida_INTERFACES()");
		 
//		 System.out.println("--------------------------------------------------------------------------------------------------");
		 BeansGenerales();
	}

	
	private static void BeansGenerales() {
		System.out.println("\n1.2. ->BeansGenerales()	:se declara a nivel general para todos los <beans>");
		System.out.println("CONSTRUCTORES");
		System.out.println("* Construir primero  'Bean<PADRE>' y segun fueron declaradas las [propiedades.privadas] de este;  Construira en  orden  DESCENDENTE a los  'Beans<HIJOS>'");
		System.out.println("CICLO_DE_VIDA_BEAN, por metodo.init(), metodo.destroy");
		System.out.println("+ Inicializar los  'Beans<HIJOS>'  internos; su orden sera DESCENDENTE, segun fueron declaradas las [propiedades.privadas] en el  'Bean<PADRE>'");
		System.out.println("+ Destruir el 'Bean<PADRE>' y despues los  'Beans<HIJOS>';  segun fueron declarados en la clase.PADRE   #   o llamados  desde el getBEan"+"\n\n");

		String configLocation = "com/company/xml/bean9_interfazBean_InitializingDisposable.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	   //:S
	     Persona persona   = (Persona) applicationContext.getBean("BEAN_PersonaID"); //A
	     Pais pais               = (Pais) applicationContext.getBean("pais");                            //B
	     Ciudad ciudad       = (Ciudad) applicationContext.getBean("ciudad");                   //C
	     
	     
	     System.out.println("    A- " + persona);
	     System.out.println("    B- " + pais);
		 System.out.println("    C- " + ciudad);
		 


	     ((ConfigurableApplicationContext) applicationContext).close();
	}

}
