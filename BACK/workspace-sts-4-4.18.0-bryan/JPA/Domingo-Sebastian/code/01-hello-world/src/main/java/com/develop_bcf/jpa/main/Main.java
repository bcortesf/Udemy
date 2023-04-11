package com.develop_bcf.jpa.main;

import com.develop_bcf.jpa.entityDominio.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		//guardarPersona();
		

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Persona persona = new Persona();
			persona.setNombre("Bryan");
			
			em.persist(persona);
			em.getTransaction().commit();
			
			Persona findPersona = em.find(Persona.class, "Bryan");
			System.out.println(findPersona.getNombre());
		em.close();
		emf.close();
	}
	
	public static void guardarPersona() {
		/**
		 * /01-hello-world/src/main/resources/META-INF/persistence.xml
		 * linea:	<persistence-unit name="jpa_main">
		 */
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Persona persona = new Persona();
			persona.setNombre("Bryan");
			
			em.persist(persona);         //Cambiar estado de la Entidad, setter @Entity
			em.getTransaction().commit();//hacer guardado en dataBase
		em.close();						 //cierra transacciones o peticiones a la dataBase
		emf.close();					 //cierra pool de conexiones y finaliza proceso	
	}

}
