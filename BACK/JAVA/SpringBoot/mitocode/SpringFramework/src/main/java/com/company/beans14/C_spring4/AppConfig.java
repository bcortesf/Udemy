package com.company.beans14.C_spring4;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.company.beans14.A2_xml.Brasil;
import com.company.beans14.B_annotations.Camiseta;
import com.company.beans14.B_annotations.Jugador;
import com.company.beans14.B_annotations.Marca;

/**
 * https://www.youtube.com/watch?v=T00FyeedYwQ&list=PLvimn1Ins-40CImsffjCkv_TrKzYiB1gb&index=24
 * <Jugador> tiene ->  IEquipo @Qualifier en <Brasil>
 * <Jugador> tiene ->  @AutoWired <Camiseta>
 * 
 * <Camiseta> tiene ->  @AutoWired <Marca>
 * 
 *  https://stackoverflow.com/questions/52421944/what-is-the-difference-between-componentscans-and-componentscan
 */


@Configuration
@ComponentScan( basePackages = "com.company.beans14.B_annotations" )
public class AppConfig {
	
	///////////////////////////////////////////
	//				->CLASE-JUGADOR:		CONTIENE_A =
	@Bean
	public Jugador BEAN_JugadorID() { //->nombre-bean: un alias que yo quiera
		return new Jugador();
	}
	@Bean
	public Brasil brasil_por_defecto() {//->nombre-bean: se debe poner el mismo del Qualifier, al tener esa etiqueta para clase<Brasil>
		return new Brasil();
	}
	@Bean
	public  Camiseta camiseta() { //->nombre-bean: el estandar es el mismo nombre de la clase, en minuscula la primer letra.
		return new Camiseta();
	}

	///////////////////////////////////////////
	//				->CLASE-CAMISETA:		CONTIENE_A =
	@Bean
	public Marca BEAN_MarcaID() {
		return new Marca();
	}
}
