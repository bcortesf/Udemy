package com.company.springMySQL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.company.entityBeans.Camiseta;
import com.company.entityBeans.Equipo;
import com.company.entityBeans.Jugador;
import com.company.entityBeans.Marca;
import com.company.service.IServiceJugador;

/**
<!--
		Spring Framework Tutorial - 25 MySQL
 		https://www.youtube.com/watch?v=hinfBLVsqF4&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb
-->
 *
 */
public class App2 
{
    public static void main( String[] args )
    {
        System.out.println( "Spring Framework Tutorial - 25 MySQL" );        
        
        String configLocation = "com/company/xml/beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(configLocation);
        
        //Objeto[Marca] se pasa a:    CapaServicios -> CapaRepositoryDao
        IServiceJugador iServiceJugador = (IServiceJugador) applicationContext.getBean("serviceJugadorImpl"); //1.instancia primer capa[Servicice]
                
        Jugador  jugador = App2.getJugador(applicationContext);                         //2.data
        
        try {
        	System.out.println("toString: " + jugador.toString());
        	iServiceJugador.registrar(jugador);
			System.out.println("ALMACENADO-CON-EXITO");
		} catch (Exception e) {
			System.err.println("ERROR :#  :" + e.getMessage());
			e.printStackTrace();
		}

        System.out.println("OK!!");
        ((ConfigurableApplicationContext) applicationContext).close();
    }
    
    /**
     * PARA EVITAR PROBLEMAS DE CONSTRAINTS, TENER ENCUENTA:
     * 1. Guardar datos en la BASE-DATOS para tablas principales; en nuestro ejemplo seria
     * 	     * 	1.1. PRIMERO, Guardar en tabla Marca
     * 	     * 	1.2. SEGUNDO, Guardar en tabla Equipo
     *          * 	1.3. TERCERO, Guardar en tabla Camiseta
     *
     * 2. Al Crear los objetos y setearlos, IMPORTANTE que sea el mismo ID que tiene las tablas principales en BASE-DATOS
     */
    public static Jugador getJugador(ApplicationContext applicationContext) {
    	//https://www.youtube.com/watch?v=myWzHTKP72w&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&t=464s
    	Marca marca =  (Marca) applicationContext.getBean("BEAN_MarcaID");
    	
    	Equipo equipo = new Equipo();
    		equipo.setId(2	); //debe ser existente en la base de datos primaria, de lo contrario, error de CONSTRAINT
    		equipo.setNombre("Barcelona FC _mod1"); //IGNORADO
    	Camiseta camiseta = new Camiseta();
    		camiseta.setId(2);//debe ser existente en la base de datos primaria, de lo contrario, error de CONSTRAINT
    		camiseta.setNumero(30);//IGNORADO
    		camiseta.setMarca(marca);
    	////////////////////////////////////////
    	Jugador jugador = new Jugador();
    	jugador.setId(2);
    	jugador.setNombre("Lionel Messi");
    	jugador.setEquipo(equipo);
    	jugador.setCamiseta(camiseta);
    	return jugador;
    }

}
