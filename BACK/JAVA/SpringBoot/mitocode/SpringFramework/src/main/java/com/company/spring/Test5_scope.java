package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans.PersonaAO;

/**
<!--......................................................................................................................................................................................................................................
		12 Bean Scopes		
		   USO:   Ejemplo práctico para entender el alcance (scope) de los objetos manejados por spring (beans).
						 Singleton (Default) : Cuando solo se lee el AplicationContext (XML) ya hizo una instancia de todos los beans
						 Prototype: Genera una nueva instancia por llamado del método “getBean()”, al leer el AplicactionContext (XML) no crea instancias.
		   https://www.youtube.com/watch?v=DcKYjO0zUSY&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=12
...................................................................................................................................................................................................................................... -->
 */
public class Test5_scope
{
    public static void main( String[] args )
    {
    	System.out.println("test5");
    	Test5_scope.listasRestringidas_XML();
    }

	private static void listasRestringidas_XML() {
		 System.out.println("\n1. ->listasRestringidas_XML()");
		 String configLocation = "com/company/xml/bean5_scopeSingletonPrototype.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);

	     //:SINGLETON: se crea por mapeo AUTOMATICO  en "applicationContext";  por  <configLocation.XML>
	     Test5_scope.singleton(applicationContext);

	     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	     /*-> Crear una nueva instancia  //:PROTOTYPE, por metodo "getBean("nombre-bean")" */
	     PersonaAO persona   = (PersonaAO) applicationContext.getBean("BEAN_PersonaID2");
	     PersonaAO persona2 = (PersonaAO) applicationContext.getBean("BEAN_PersonaID2");
	     Test5_scope.prototype(persona, persona2);


	     ((ConfigurableApplicationContext) applicationContext).close();
	}
	
	private static void singleton(ApplicationContext applicationContext) {
		System.out.println("\n1. ->SINGLETON()	:misma instancia");
		
		/*-> Crear una nueva instancia SINGLETON, por mapeo de --> applicationContext */
		PersonaAO persona   = (PersonaAO) applicationContext.getBean("BEAN_PersonaID");
		PersonaAO persona2 = (PersonaAO) applicationContext.getBean("BEAN_PersonaID");
	     
	     //->Si modifico un objeto, todos los  objetos nuevos , seran IGUALES al modificado; porque es misma instancia
	     persona.setId(1); persona.setNombre("Bryan");
		 System.out.println("" + persona.hashCode() + "  ~~  " + persona);
		 System.out.println("" + persona2.hashCode() + "  ~~  " + persona2); 
	}
	private static void prototype(PersonaAO persona, PersonaAO persona2) {
		System.out.println("\n2. ->PROTOTYPE()	:diferentes instancias");
		
	     //->Si modifico un objeto, todos los demas objetos nuevos , seran DIFERENTES al modificado; porque son instancias diferentes
	     persona.setId(1); persona.setNombre("Bryan");
	     System.out.println("" + persona.hashCode() + "  ~~  " + persona);
	     System.err.println("" + persona2.hashCode() + "  ~~  " + persona2);
	}
    
}
