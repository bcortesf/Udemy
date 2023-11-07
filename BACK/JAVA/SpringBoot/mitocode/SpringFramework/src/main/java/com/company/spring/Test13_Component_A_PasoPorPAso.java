package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans13.Jugador_Component;

/**
<!--......................................................................................................................................................................................................................................
		21 Stereotypes
		   USO:  Spring te permite usar anotaciones para simplificar las definiciones en el archivo de configuración xml, 
		             estas anotaciones son @Component, @Service @Controller, @Repository conocido como esteriotipos
			https://www.youtube.com/watch?v=7qGRWEk0kDM&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=21	
			
			@Component : Es lo mismo que tener un Bean en XML, porque lo mapea automatico;
			- Si una clase tiene @Component; entonces en el archivo "bean13_Component.XML", borrar el BEAN completo
			https://youtu.be/7qGRWEk0kDM?list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=51
			- Diferencias
				- Reconoce @Autowired @Qualifier
				<context:annotation-config />
				- Recoce  @Component, @Service @Controller, @Repository
    			<context:component-scan base-package="com.company">
			https://youtu.be/7qGRWEk0kDM?list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=126
...................................................................................................................................................................................................................................... -->
 */
public class Test13_Component_A_PasoPorPAso
{
    public static void main( String[] args )
    {
    	System.out.println("test13-A");

//    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test13_Component_A_PasoPorPAso.Beans();
    }

	private static void Beans() {
		 System.out.println("\n3. ->Beans()	:.");

		 String configLocation = "com/company/xml/bean13_Component_A_PasoPorPaso.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	     
	     //llamar a la clase , con la primera leta en minuscula
	     Jugador_Component lioMessi = (Jugador_Component) applicationContext.getBean("jugador_Component") ;
	     
		 System.out.println(lioMessi);
		 System.out.println(lioMessi.getNombre());
		 System.out.println(lioMessi.getEquipo().mostrarNombre());

	     ((ConfigurableApplicationContext) applicationContext).close();
	}


}
