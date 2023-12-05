package com.develop_bcf.jpa.main;

import java.util.List;

import com.develop_bcf.jpa.entityDominio.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
/**
 * SOLUCION-WARNINGS
 * 1. Description	Resource	Path	Location	Type
      Project '01-hello-world' has no explicit encoding set	01-hello-world		
      /01-hello-world	No explicit project encoding
		
 *    https://stackoverflow.com/questions/72692978/eclipse-project-project-name-has-no-explicit-encoding-set
 *    Ctrl + 1 : sobre el error
 */
public class Main {

	public static void main(String[] args) {
//		guardarPersona();
//		consultarPersonaFind();
//		consultarPersonaQuerys_getReference();
		personaEqualsHashcode();

	}
	
	public static void personaEqualsHashcode() {
		System.out.println("metodo:    personaEqualsHashcode()");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Persona persona1 = new Persona();
			Persona persona2 = new Persona();
			Persona persona3 = new Persona();
			persona1.setId(1);	persona1.setNombre("Bryan");	persona1.setPais("COL");
			persona2.setId(2);  persona2.setNombre("Moticas");	persona2.setPais("ANGELES");
			persona3.setId(3);  persona3.setNombre("Minnie");	persona3.setPais("COL");
			
			em.persist(persona1);
			em.persist(persona2);
			em.persist(persona3);
			em.getTransaction().commit();
			
			Persona personaFind  = em.find(Persona.class, 2);
			
			System.out.println(personaFind);
			System.out.println("persona2.equals(personaFind)" + persona2.equals(personaFind));
			System.out.println("personaFind.equals(persona2)" + personaFind.equals(persona2));

			
		em.close();
		emf.close();		
	}

	public static void consultarPersonaQuerys_getReference() {
		System.out.println("metodo:    consultarPersonaQuerys_getReference()");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Persona persona1 = new Persona();
			Persona persona2 = new Persona();
			Persona persona3 = new Persona();
			persona1.setId(1);	persona1.setNombre("Bryan");	persona1.setPais("COL");
			persona2.setId(2);  persona2.setNombre("Moticas");	persona2.setPais("ANGELES");
			persona3.setId(3);  persona3.setNombre("Minnie");	persona3.setPais("COL");
			
			em.persist(persona1);
			em.persist(persona2);
			em.persist(persona3);
			em.getTransaction().commit();


			//https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/select-from-where-statement.html
			Query queryAll = em.createQuery("SELECT e FROM Persona e");
			Query queryByName = em.createQuery("SELECT e FROM Persona e WHERE e.nombre = :peopleName");


			//Buscar todas las personas
			@SuppressWarnings("unchecked")
			List<Persona> resultList = queryAll.getResultList();
			resultList.forEach(System.out::println);
			//Buscar persona por nombre
			queryByName.setParameter("peopleName", "Minnie");

			/**
			 * https://stackoverflow.com/questions/1607532/when-to-use-entitymanager-find-vs-entitymanager-getreference-with-jpa
			 * find			: realiza interno un SELECT, porque se necesita por ejemplo para un DTO salida
			 * getReference : crea referencia sin hacer un SELECT, si solo se necesita el <primaryKey>, para UPDATE,DELETE;
			 * 				  crea referencia y hace un SELECT, si se usa un getter distinto al Entity.<primaryKey>;
			 */
			Persona entity1 = em.find(Persona.class, 1); //<Entity>,<primaryKey= Persona.id>
			Persona entity2 = em.getReference(Persona.class, 2);
			System.out.println();
			System.out.println(entity1.getNombre());
			System.out.println(entity2.getNombre() + "\n");
			
			Persona entity3 = (Persona) queryByName.getSingleResult();
			System.out.println(entity3.getNombre());
			System.out.println("tipo de clase entity3:\t" + entity3.getClass().getName());
			
		em.close();
		emf.close();		
	}
	
	public static void consultarPersonaFind() {
		System.out.println("metodo:    guardarPersona()");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
			Persona persona1 = new Persona();
			persona1.setNombre("Bryan");
			
			em.persist(persona1);
			em.getTransaction().commit();
			
			Persona entity1 = em.find(Persona.class, "Bryan");
			System.out.println(entity1.getNombre());
		em.close();
		emf.close();		
	}
	
	// https://stackoverflow.com/questions/72692978/eclipse-project-project-name-has-no-explicit-encoding-set
	public static void guardarPersona() {
		System.out.println("metodo:    guardarPersona()");
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
