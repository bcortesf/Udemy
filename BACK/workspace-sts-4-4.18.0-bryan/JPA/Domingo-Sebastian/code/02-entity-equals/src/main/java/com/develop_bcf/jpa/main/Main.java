package com.develop_bcf.jpa.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.develop_bcf.jpa.entityDomain.Persona;
import com.develop_bcf.jpa.entityDomain.PersonaIDENTITY;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
	static EntityManager        em  = emf.createEntityManager();

	public static void main(String[] args) {
		try {
			em.getTransaction().begin();
			
//			guardarPersona___1();
//			consultarPersona_1();
			
			propiedadSintetica();
//			m3();
//			m4();

			//Dentro de otra transacción
//			m5();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR-LANZADO:\t" + e.getCause());
			System.out.println("ERROR-MENSAJE:\t" + e.getMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
	}
	
	public static void guardarPersona___1() {
		System.out.println("metodo    guardarPersona___1()");
		Persona persona1 = new Persona();
		Persona persona2 = new Persona();
		persona1.setId(1);	persona1.setNombre("bryan"); 	persona1.setPais("CO");
		persona2.setId(2);	persona2.setNombre("Moticas"); 	persona2.setPais("AN");
		
		em.persist(persona1);
		em.persist(persona2);
		//em.getTransaction().commit();
	}
	
	public static void consultarPersona_1() {
		System.out.println("\nmetodo    consultarPersona_1()");
		Persona personaTemp = new Persona();
				personaTemp.setId(2);	
				personaTemp.setNombre("Moticas"); 	personaTemp.setPais("AN");
		
		Persona personaFind2 = em.find(Persona.class, 2);
		Persona personaRefe2 = em.getReference(Persona.class, 2);
		
		System.out.println("personaFind2:\t".concat(personaFind2.toString()));
		System.out.println("personaTemp.equals(personaFind2)?" + personaTemp.equals(personaFind2));
		System.out.println("personaFind2.equals(personaTemp)?" + personaFind2.equals(personaTemp));
		System.out.println("------");
		System.out.println("personaTemp.equals(personaRefe2)?" + personaTemp.equals(personaRefe2));
		System.out.println("personaRefe2.equals(personaTemp)?" + personaRefe2.equals(personaTemp));
		
	}
	
	public static void propiedadSintetica() {
		System.out.println("\nmetodo    propiedadSintetica()");
		List<PersonaIDENTITY> personasSave = new ArrayList<PersonaIDENTITY>();
		personasSave.add(new PersonaIDENTITY("Moticas", "ANG"));//1
		personasSave.add(new PersonaIDENTITY("Shushi", "COL")); //2
		personasSave.add(new PersonaIDENTITY("Minnie", "COL")); //3
		//save
		for (PersonaIDENTITY personaIDENTITY : personasSave) {
			em.persist(personaIDENTITY);
		}
		//show
		Collection<PersonaIDENTITY> personasShow = em
				.createQuery("Select p from PersonaIDENTITY p", PersonaIDENTITY.class)
				.getResultList();
		for (PersonaIDENTITY personaIDENTITY : personasShow) {
			System.out.println(personaIDENTITY);
		}
	}
	
	public static void m3() {
		System.out.println("\nmetodo    m3()");
	}

}


/*public static void m4() {
System.out.println("metodo    m4()");
EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
EntityManager em = emf.createEntityManager();
em.getTransaction().begin();
	//
em.close();
emf.close();
}*/
