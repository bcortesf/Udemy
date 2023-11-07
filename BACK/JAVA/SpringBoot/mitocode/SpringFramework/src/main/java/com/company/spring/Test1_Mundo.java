package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans1.AppConfig;
import com.company.beans1.AppConfigAux2;
import com.company.beans1.Mundo;

/**
 * https://www.youtube.com/watch?v=NL0nxFwTRws&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=130s	:modulo context(Beans, Core)
 * https://www.youtube.com/watch?v=NL0nxFwTRws&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=261s	:crear folder, para registro de beans por xml
 * 
 * https://www.youtube.com/watch?v=NL0nxFwTRws&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=490s	:referenciar<BEANS> por "beans.xml", en (mismo  o distinto) paquete
 * https://www.youtube.com/watch?v=e4AxCA4jPoY&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=146s		:referenciar<BEANS> por "ClaseConfiguracion"
 */

/**
<!--......................................................................................................................................................................................................................................
		4 Hola Mundo
		   USO:  Creación del proyecto maven; se tocarán temas como beanFactory, ApplicationContext, y un ejemplo del uso sencillo de Spring
		   https://www.youtube.com/watch?v=NL0nxFwTRws&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=4
				  
		5 Configuración con Anotaciones
		   USO:  uso de las anotaciones @Configuration y @Bean, algunas consideraciones adicionales y contrastaremos con el uso en XML.
		   https://www.youtube.com/watch?v=e4AxCA4jPoY&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=5
...................................................................................................................................................................................................................................... -->
 */
public class Test1_Mundo 
{
    public static void main( String[] args )
    {
    	System.out.println("test1");
    	Test1_Mundo.instanciaTradicional();
    	Test1_Mundo.instanciaSpringPor_XML();
    	Test1_Mundo.instanciaSpringPor_ClaseConfiguracion();
    	
    }

    private static void instanciaSpringPor_ClaseConfiguracion() {
    	// https://www.youtube.com/watch?v=e4AxCA4jPoY&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=146s
    	System.out.println("\n3. ->instanciaSpringPor_ClaseConfiguracion()");

    	Test1_Mundo.instanciaSpringPor_ClaseConfiguracionUnica();
    	Test1_Mundo.instanciaSpringPor_ClaseConfiguracionMultiple();
    }
    private static void instanciaSpringPor_ClaseConfiguracionUnica() {
    	System.out.println("\t3.1. ->ClaseConfiguracionUnica()    :una clase configuracion");

    	//->definida en paquete com.company.beans.AppConfig.java
    	ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    	//->Se aplica patron factoria, mediante un ID, nos devuelve una instancia
    	Mundo mundo1 = (Mundo) applicationContext.getBean("BEAN_MundoID");  //->AppConfig.class
    	System.out.println("\tAppConfig.class      :" + mundo1.getSaludo());
    	
    	((ConfigurableApplicationContext) applicationContext).close();
    }
    private static void instanciaSpringPor_ClaseConfiguracionMultiple() {
    	System.out.println("\n\t3.2. ->ClaseConfiguracionMultiple()    :muchas clases configuraciones");
    	//->definida en paquete com.company.beans.AppConfigAux2.java

    	//->OPCION#1
    	//ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class, AppConfigAux2.class);
    	
    	//->OPCION#2
    	AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    		applicationContext.register(AppConfig.class);
    		applicationContext.register(AppConfigAux2.class);
    		applicationContext.refresh(); //reconstruir todos los archivos de configuracion
    	

    	//->Se aplica patron factoria, mediante un ID, nos devuelve una instancia
    	Mundo mundo1 = (Mundo) applicationContext.getBean("BEAN_MundoID");  //->AppConfig.class
    	System.out.println("\tAppConfig.class      :" + mundo1.getSaludo());
    	Mundo mundo2 = (Mundo) applicationContext.getBean("BEAN_World2ID"); //->AppConfigAux2.class
    	System.out.println("\tAppConfigAux2.class  :" + mundo2.getSaludo());
    	
    	((ConfigurableApplicationContext) applicationContext).close();
    }
    
    
    private static void instanciaSpringPor_XML() {
    	// https://www.youtube.com/watch?v=NL0nxFwTRws&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=490s
    	System.out.println("\n2. ->instanciaSpringPor_XML()");

    	String configLocation = "com/company/xml/bean1_Mundo.xml";
    	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
    	
    	//Se aplica patron factoria, mediante un ID, nos devuelve una instancia
    	Mundo mundo1 = (Mundo) applicationContext.getBean("BEAN_MundoID");
    	Mundo mundo2 = (Mundo) applicationContext.getBean(Mundo.class);
//    	            mundo2.setSaludo("Hi Bryan");

    	System.out.println(mundo1.getSaludo()); //->Hola Bryan!!
    	mundo2.setSaludo("Hi Bryan");
    	System.out.println(mundo2.getSaludo()); //->Hi Bryan!!
    	
    	((ConfigurableApplicationContext) applicationContext).close();
    }

	private static void instanciaTradicional() {
		System.out.println("\n1. ->formaTradicional()");

        Mundo world = new Mundo();
        world.setSaludo("¡¡Saludo tradicional!!");
        System.out.println( world.getSaludo() );
	}
    
}
