package com.develop_bcf.jpa;

import java.util.Set;

import com.develop_bcf.jpa.EntityDomain.Carro;
import com.develop_bcf.jpa.EntityDomain.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
	static EntityManager        em  = emf.createEntityManager();

	public static void main(String[] args) {
//		test();
		
		try {
			em.getTransaction().begin();
			
			guardarPersona();
			consultar();
			
//			m3();
//			m4();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR-LANZADO:\t" + e.getCause());
			System.out.println("ERROR-MENSAJE:\t" + e.getMessage());
//			System.out.println("ERROR-LOCALIZADO:\t" + e.getCause().getLocalizedMessage());
		} finally {
			em.getTransaction().commit();
			em.close();
			emf.close();
		}
	}

	
	public static void guardarPersona() {
		System.out.println("metodo    guardarPersona()");

		Persona persona1 = new Persona(1011, "Bryan");
		Carro carro1 = new Carro("ABC-001", "Ford"  , persona1);
		Carro carro2 = new Carro("ABC-002", "Camaro", persona1);
		Carro carro3 = new Carro("ABC-003", "Nissan", persona1);
		
		persona1.getCoches().add(carro1);
		persona1.getCoches().add(carro2);
		persona1.getCoches().add(carro3);

		em.persist(persona1);
		em.persist(carro1);
		em.persist(carro2);
		em.persist(carro3);
		
		/////////////////////////////////////////////////////////////////////		
		Persona persona2 = new Persona(2022, "Jorge");
		Carro carro4 = new Carro("DEF-004", "Subaru");
		Carro carro5 = new Carro("DEF-005", "Honda");
		Carro carro6 = new Carro("DEF-006", "Audi");
		
		carro4.setPropietarioFK(persona2);
		carro5.setPropietarioFK(persona2);
		carro6.setPropietarioFK(persona2);
		persona2.getCoches().add(carro4);
		persona2.getCoches().add(carro5);
		persona2.getCoches().add(carro6);
		
		em.persist(persona2);
		em.persist(carro4);
		em.persist(carro5);
		em.persist(carro6);

		//////////////////////////////////////////////////	
//		em.getTransaction().commit();
	}

	// https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/select-from-where-statement.html
	public static void consultar() {
		final String[] FIND_VALUE = {"Bryan", "Jorge"};
		
		/*Query query = em
				.createQuery("select p from Persona p where p.nombre = :nombreFIND", Persona.class);
		query.setParameter("nombreFIND", FIND_VALUE[0]);	//cambio		
		Persona persona = (Persona)query.getSingleResult();
		
		consultarCochesConPersonaAsociada(persona.getCoches());
		consultarPersonaConcochesAsociados(persona); */
		for (String nombrePersona : FIND_VALUE) {
			Query query = em
					.createQuery("select p from Persona p where p.nombre = :nombreFIND", Persona.class);
			query.setParameter("nombreFIND", nombrePersona);		
			Persona persona = (Persona)query.getSingleResult();
			
			consultarCochesConPersonaAsociada(persona.getCoches());
			consultarPersonaConcochesAsociados(persona);
		}
	}
	private static void consultarCochesConPersonaAsociada(Set<Carro> coches) {
		System.out.println("\nmetodo    consultarCochesConPersonaAsociada()");
		for (Carro carro : coches) {
			System.out.println(carro.toString());
		}
	}
	private static void consultarPersonaConcochesAsociados(Persona persona) {
		System.out.println("\nmetodo    consultarPersonaConcochesAsociados()");
		System.out.println(persona.toString_2());
		System.out.println("-------------------------------\n");
	}


	public static void propiedadSintetica() {
		System.out.println("\nmetodo    propiedadSintetica()");
	}
	
	public static void m3() {
		System.out.println("\nmetodo    m3()");
	}
	
	public static void test() {
		EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("jpa_main");
		
		Persona ana = new Persona();
        ana.setNombre("Ana");
        
        Carro coche = new Carro();
        coche.setModelo("suzuki");
        coche.setPropietarioFK(ana);
        
        Persona juan = new Persona();
        juan.setNombre("Juan");
        
        juan.getCoches().add(coche);

        EntityManager em1 = emf1.createEntityManager();
        em1.getTransaction().begin();
        em1.persist(ana);
        em1.persist(coche);
        em1.persist(juan);
  
        em1.refresh(coche);
        em1.refresh(juan); //poner a modo de prueba
        System.out.println("propietario " + coche.getPropietarioFK().getNombre());     //ana
        System.out.println("cuantos coches tiene Juan? = " + juan.getCoches().size()); //1-porque? = Juan se le agrego uno desde Persona
        System.out.println("cuantos coches tiene Ana?  = " + ana.getCoches().size());  //0-porque? = Ana no se asocio un <Carro.list> desde <Persona>
        
        em1.getTransaction().commit();
        em1.close();

        emf1.close();
        System.out.println("FIN-TEST");
	}

}

