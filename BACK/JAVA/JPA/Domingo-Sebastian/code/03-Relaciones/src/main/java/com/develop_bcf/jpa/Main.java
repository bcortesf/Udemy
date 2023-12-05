package com.develop_bcf.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import com.develop_bcf.jpa.EntityDomain.Carro;
import com.develop_bcf.jpa.EntityDomain.Persona;
import com.develop_bcf.jpa.EntityDomain.Cascada.Carro_Cascada;
import com.develop_bcf.jpa.EntityDomain.Recursive.PadreRecursivo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");
	static EntityManager        em  = emf.createEntityManager();
	static Boolean         EJECUTAR = true;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		test();
		cascada_updateEntity();

		try {
			em.getTransaction().begin();
			
			if(1 == 11) {
				guardarPersona();
				consultar();
			}
			if (2 == 22) {
				relacionesrecursivas();
			}
			if (3 == 33) {
				propagacionCascada();
			}
			

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
	
	public static void relacionesrecursivas() {
		System.out.println("\nmetodo    relacionesrecursivas()");
		
		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:testBaseDatos");
			con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('abuelo',null)");	//1L
	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('padre',1)");		//2L
	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('yo',2)");		//3L
	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('hijo',3)");		//4L
	        
	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('nieto-UNO',4)");	//5L
	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('nieto-DOS',4)");	//5L

	        con.createStatement().executeUpdate("insert into PERSONA_R (nombre, padre_id) values ('bisnieto',5)");	//6L
	        con.commit();


	        System.out.println("\n @ManyToOne:  obtiene todos los padres antepasados ");
	        PadreRecursivo persona1 = em.find(PadreRecursivo.class, 2L);
	        while (persona1 != null) {
	        	System.out.println(persona1.getNombre());
	        	persona1 = persona1.getPadre();
	        }
	        
	        System.out.println("-----------------------------------------------------");
	        System.out.println("\n @OneToMany:  obtiene todos los hijos del futuro ");
	        PadreRecursivo persona2 = em.find(PadreRecursivo.class, 4L);
	        while (persona2 != null) {     	
	        	System.out.println("\n".concat(persona2.getNombre()));
	        	
	        	List<PadreRecursivo> hijos = persona2.getHijo();
	        	if (hijos.size() > 0) {
	        		System.out.println("#Cantidad-hijos :" + hijos.size());

	        		persona2 = hijos.get(0);
	        		//System.out.println("*SUCESOR*\t =>" + persona2.getNombre());

//	        		persona2 = hijos.get(hijos.size()-1);
	        		hijos.forEach( hijo -> { 
		        		System.out.println("*SUCESOR*\t =>" + hijo.getNombre());
	        		});
				}
	        	if (hijos.size() == 0) {
					persona2 = null;
				}
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}

	public static void propagacionCascada() {
		System.out.println("*propagacionCascada*");
		Carro_Cascada nuevoCoche = new Carro_Cascada();
		Persona nuevaPersona = new Persona(1013, "Miguel");
		nuevoCoche.setPropietarioFK(nuevaPersona);
		
		em.persist(nuevoCoche);
	}
	
	
	public static void cascada_updateEntity() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");

		Connection con;
		try {
			con = DriverManager.getConnection("jdbc:h2:mem:testBaseDatos");
			con.createStatement().executeUpdate("insert into persona (nombre) values ('juan')");	//1L
	        con.createStatement().executeUpdate("insert into persona (nombre) values ('ana')");		//2L
	        con.createStatement().executeUpdate("insert into persona (nombre) values ('luis')");	//3L
	        con.commit();
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        
        Carro_Cascada coche = new Carro_Cascada();
        Persona nuevaPersona = new Persona(1, "Miguel");											//4L
        coche.setPropietarioFK(nuevaPersona);
        
        EntityManager em = emf.createEntityManager();
        
        // tx 1
        em.getTransaction().begin();

        em.persist(nuevaPersona);
        em.persist(coche);
        
        em.getTransaction().commit();
        em.close();
        
        System.out.println("---------------");
        System.out.println("propi1 \t:" + coche.getPropietarioFK().getNombre());
        System.out.println("segunda tx");
        
        // tx 2
        coche.setPropietarioFK(new Persona(2, "Antonia"));											//5L?
        
        em = emf.createEntityManager();
        em.getTransaction().begin();

        em.merge(coche);
        
        em.getTransaction().commit();
        //em.close();
        //emf.close();

        System.out.println("---------------");
        System.out.println("propi2 \t:" + coche.getPropietarioFK().getNombre());
        System.out.println("---------------");
        Persona antonia5L = em.find(Persona.class, 5L);
        System.out.println("persona.nombre \t:" + antonia5L.getNombre());
        
        em.close();
        emf.close();
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

