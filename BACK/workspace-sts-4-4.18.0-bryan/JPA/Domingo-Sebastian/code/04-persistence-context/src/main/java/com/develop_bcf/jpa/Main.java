package com.develop_bcf.jpa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.develop_bcf.jpa.EntityDomain.Persona;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
	
	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_main");

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		System.out.println("hola");
//		test();
//		cascada_updateEntity();

		try {
			createEntityPersona();
			if(1 == 1) {
				updateEntityPersona_case1();
			}
			if (2 == 22) {
				updateEntityPersona_case2();
			}
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("ERROR-LANZADO:\t" + e.getCause());
			System.out.println("ERROR-MENSAJE:\t" + e.getMessage());
//			System.out.println("ERROR-LOCALIZADO:\t" + e.getCause().getLocalizedMessage());
		} finally {
			emf.close();
		}


	}
	public static void createEntityPersona() throws SQLException {
		Connection con = DriverManager.getConnection("jdbc:h2:mem:testBaseDatos");
        con.createStatement().executeUpdate("insert into PERSONA (nombre,dni) values ('shushi','12345678Z')");
        con.createStatement().executeUpdate("insert into PERSONA (nombre,dni) values ('minnie','87654321X')");
        con.commit();
	}


	/*
     * ¿Se va a generar un update para la modificación hecha en shushi?		RTA:SI
     */
	public static void updateEntityPersona_case1() {
		System.out.println("update-Entity-Persona_case1()".toUpperCase());
		EntityManager        em  = emf.createEntityManager();
		em.getTransaction().begin();
		
			Persona shushi = em.find(Persona.class, "shushi");
							 //System.out.println("BEFORE	:" + shushi);
			shushi.setMunicipio("Bogota DC");
		
		em.getTransaction().commit();
		em.close();
		System.out.println("AFTER	:" + shushi);
	}

	
	/*
     * Hemos quitado la transaccion:
     * Se va a generar un update para la modificación hecha en shushi?		rta:si
     */
	public static void updateEntityPersona_case2() {
		System.out.println("\nupdate-Entity-Persona_case2".toUpperCase());
		EntityManager em = emf.createEntityManager();

			Persona shushi = em.find(Persona.class, "shushi");
			shushi.setMunicipio("Bogota DC");

		em.close();
		System.out.println("AFTER	:" + shushi);
	}

}

