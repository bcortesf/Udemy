package com.company.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.beans11.Jugador;
import com.company.principios.InyeccionDependencia.EquipoBarcelona;
import com.company.principios.InyeccionDependencia.EquipoJuventus;
import com.company.principios.InyeccionDependencia.IEquipo;

/**
<!--......................................................................................................................................................................................................................................
		18 Uso de interfaces
		   USO:   Codificar bajo interfaces para obtener mayor flexibilidad en el código al momento de instanciar objetos de diferentes clases.
			https://www.youtube.com/watch?v=6Wv8vR0qVdU&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=18
...................................................................................................................................................................................................................................... -->
 */
public class Test11_interfaces_instanciarObjetoClase
{
    public static void main( String[] args )
    {
    	System.out.println("test11");

    	Test11_interfaces_instanciarObjetoClase.InyeccionDependencias_sinXML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test11_interfaces_instanciarObjetoClase.InyeccionDependencias_conXML();
    	System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------");
    	Test11_interfaces_instanciarObjetoClase.Beans();
    }
    
    private static void InyeccionDependencias_sinXML() {
		 System.out.println("\n1. ->InyeccionDependencias_sinXML()	: usando las 2 clases: Jugador.class, equipo-polimorfismo");
	        
//	     IEquipo equipo = () -> "Manchester United";
	     IEquipo equipo = new EquipoJuventus();
		 Jugador ronaldoCR7 = new Jugador();
		 ronaldoCR7.setNombre("Cristiano Ronaldo");
		 ronaldoCR7.setNumero(7);
		 ronaldoCR7.setEquipo(equipo);
	     
		 System.out.println(ronaldoCR7);
		 System.out.println(ronaldoCR7.getNombre());
		 System.out.println(ronaldoCR7.getEquipo().mostrarNombre());
	}
    
    private static void InyeccionDependencias_conXML() {
		 System.out.println("\n2. ->InyeccionDependencias_conXML()	:");
		 
		 String configLocation = "com/company/xml/bean11_interfaces_instanciarObjetoClases.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);

	     /* GENERAL */
	     System.out.println("\t->2.1. 'Por interfaz general {General}:    **'RECOMENDADO'**");
		 IEquipo equipo = (IEquipo) applicationContext.getBean("BEAN_EquipoJuventusID"); //el Bean que quiera, y sin castear a una especifica
		 System.out.println("\t"+ equipo + "    ~~    " + equipo.mostrarNombre());
	     
	     /* ESPECIFICA */
	     System.out.println("\n\t->2.2. 'Por clase concreta {Especifica}:    --MALAS-PRACTICAS-DESARROLLO--\n");
	     EquipoBarcelona barcelona = (EquipoBarcelona) applicationContext.getBean("BEAN_EquipoBarcelonaID");
	     EquipoJuventus juventus      = (EquipoJuventus) applicationContext.getBean("BEAN_EquipoJuventusID");
		 System.out.println("\t"+ barcelona + "    ~~    " + barcelona.mostrarNombre());
		 System.out.println("\t" + juventus  + "\t  ~~     " + juventus.mostrarNombre());


	     ((ConfigurableApplicationContext) applicationContext).close();
	}

	private static void Beans() {
		 System.out.println("\n3. ->Beans()	:Codificar bajo interfaces para obtener mayor flexibilidad en el código al momento de instanciar objetos de diferentes clases.");

		 String configLocation = "com/company/xml/bean11_interfaces_instanciarObjetoClases.xml";
	     ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
	        
	     Jugador lioMessi = (Jugador) applicationContext.getBean("BEAN_JugadorMessiID") ;
	     
		 System.out.println(lioMessi);
		 System.out.println(lioMessi.getNombre());
		 System.out.println(lioMessi.getEquipo().mostrarNombre());

	     ((ConfigurableApplicationContext) applicationContext).close();
	}


}
