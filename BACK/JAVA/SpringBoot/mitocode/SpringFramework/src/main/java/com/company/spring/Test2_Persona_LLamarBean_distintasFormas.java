package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans2.Persona;

/**
<!--......................................................................................................................................................................................................................................
		6 Inyección por Constructor
		   USO:   uso de la inyección de dependencias que brinda spring por medio de su container, a nivel de constructor
		   https://www.youtube.com/watch?v=p_UOlp7kMM0&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=6

		7 Inyección de Objetos
		   USO:   como inyectar los valores de los objetos contenidos en otros objetos, Por XML atributo [ref]
		   https://www.youtube.com/watch?v=yELUdjphITA&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=7
		   
		 8 Beans Anidados
		   USO:    otra manera de poder asociar un bean contenido en otro bean en el archivo de configuración xml de spring.
		   https://www.youtube.com/watch?v=un4Mj7FQfWU&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=8
		   
		 9 Referenciando Beans
		   USO:    distintas manera de poder llamar a un bean por medio de su id, alias o el atributo name
		   https://www.youtube.com/watch?v=t70l3QEVMKo&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=9
...................................................................................................................................................................................................................................... -->
 */
public class Test2_Persona_LLamarBean_distintasFormas 
{
    public static void main( String[] args )
    {
    	System.out.println("test2");
    	Test2_Persona_LLamarBean_distintasFormas.instanciaSpringPor_XML();
    	
    }

	private static void instanciaSpringPor_XML() {
		 System.out.println("\n1. ->instanciaSpringPor_XML()");
		 String configLocation = "com/company/xml/bean2_Persona_ReferenciaBean_DistintasFormas.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	   /*-> Crear una nueva instancia */
//	     Persona persona = applicationContext.getBean(Persona.class);                                          //no usa archivo.xml
	     Persona persona = (Persona) applicationContext.getBean("BEAN_PersonaID");                    //[Bean].id
//	     Persona persona = (Persona) applicationContext.getBean("personaBeanApodo_ALIAS");     //[alias].alias
//	     Persona persona = (Persona) applicationContext.getBean("BEAN_PersonaNAME");              //[Bean].name
	     System.out.println("" + persona);


	     ((ConfigurableApplicationContext) applicationContext).close();
	}
    
}
