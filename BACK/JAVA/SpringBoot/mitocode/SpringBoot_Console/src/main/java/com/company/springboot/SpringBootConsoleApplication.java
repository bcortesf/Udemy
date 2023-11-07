package com.company.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.springboot.entity.Persona;
import com.company.springboot.service.IPersonaService;
//import com.company.springboot.service.PersonaServiceImpl;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
	
	private static Logger LOG = LoggerFactory.getLogger(SpringBootConsoleApplication.class);
	
	/** EL ORDEN DE LLAMADO DE CAPAS ES:
	 * 	1. @Controller -> 2. @Service -> 3. @Repositorio
	 * 	1. @Service -> 2. @Repositorio
	 */
	@Autowired
	private IPersonaService iPersonaService;		//:busca la instancia que tiene su siguiente capa: "PersonaServiceImpl", por el stereotipo @Service  ~~ equivalente al  "->JAVA-PURO"


	public static void main(String[] args) {
		SpringApplication.run(SpringBootConsoleApplication.class, args);
	}

	/**
	 * SobreEscribiendo metodo run();   dentro del  main:        public static void main(String[] args) {...} 
	 * linea 15:	SpringApplication.run()
	 */
	@Override
	public void run(String... args) throws Exception {
		//usarSiempreLOGGERS();

		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("BryanCF");
		
		//iPersonaService = new PersonaServiceImpl();   /*->JAVA-PURO*/
		iPersonaService.registrar(persona);
	}


	//----------------------------------------------------------------------------------------------------------------
	/* LO IDEAL ES QUITAR LOS  SYSTEM.OUT.PRINT,  Y CAMBIARLOS POR ---> LOGGERS */
	@SuppressWarnings("unused")
	private void usarSiempreLOGGERS() {
		//System.out.println("Hola Bryan-Coder, desde Spring Boot en consola.");
		LOG.info("Hola Bryan-Coder, desde Spring Boot en consola.");
		LOG.warn("Advirtiendo a los Coders que llego el master");
		LOG.error("El coder encontro un error");
	}

}
