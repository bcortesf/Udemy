package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans.PersonaAO;

/**
<!--......................................................................................................................................................................................................................................
		13 Carga Tardía Beans (Lazy Loading)
		   USO:   como poder inicializar los beans de manera tardía (lazy)
			https://www.youtube.com/watch?v=9fRPp0wzU0k&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=13
			https://www.youtube.com/watch?v=9fRPp0wzU0k&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=108s
...................................................................................................................................................................................................................................... -->
 */
public class Test6_LazyLoading_CargaTardia
{
    public static void main( String[] args )
    {
    	System.out.println("test6");
    	Test6_LazyLoading_CargaTardia.listasRestringidas_XML();
    }

	private static void listasRestringidas_XML() {
		 System.out.println("\n1. ->listasRestringidas_XML()");
		 String configLocation = "com/company/xml/bean6_LazyLoadin_CargaTardia.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	   //:SINGLETON: se crea por mapeo.MANUAL  en "applicationContext";  en  <configLocation.XML> con la propiedad --> lazy-init="true"
	   //                      en el momento que haga el llamado con el metodo "getBean"
	     Test6_LazyLoading_CargaTardia.singleton_LazyLoading(applicationContext); 


	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	
	private static void singleton_LazyLoading(ApplicationContext applicationContext) {
		System.out.println("\n1. ->SINGLETON_LazyLoading_CargaTardia()	:misma instancia");
		
		/*
		 * -> Crear una nueva instancia SINGLETON, MANUAL  por mapeo de --> applicationContext.  Cuando la propiedad es   [lazy-init="true"]
		 *     Es decir se comporta como un scope="Prototype" 
		 *     
		 *     Si se usa la interfaz "BeanFactory", por defecto la propiedad es   [lazy-init="true"]
		 * */
		PersonaAO persona   = (PersonaAO) applicationContext.getBean("BEAN_PersonaID");
	     PersonaAO persona2 = (PersonaAO) applicationContext.getBean("BEAN_PersonaID");
	     
	     //->Si modifico un objeto, todos los  objetos nuevos , seran IGUALES al modificado; porque es misma instancia
	     persona.setId(1); persona.setNombre("Bryan");
		 System.out.println("" + persona.hashCode() + "  ~~  " + persona);
		 System.out.println("" + persona2.hashCode() + "  ~~  " + persona2); 
	}
    
}
