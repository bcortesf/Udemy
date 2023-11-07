package com.company.springboot;



import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.company.springboot.entityModel.Usuario;
import com.company.springboot.repository.IUsuarioRepo;

@SpringBootTest
class SpringBootThymeleafMvcApplicationTests {

	@Autowired
	private IUsuarioRepo iUsuarioRepo;
	
	/**
	 * Referencia al Bean declarado en :
	 * /SpringBoot_ThymeleafMVC/src/main/java/com/company/springboot/SecurityConfig.java
	 */
	@Autowired
	private BCryptPasswordEncoder encoder; 

	/**
	 * https://www.youtube.com/watch?v=ksLYIavT2L0&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&t=263s
	 * Las pruebas deben pensarse como  escenarios
	 * Definir Parametros de entrada
	 * Cuales son los Parametros de salida, que se esperan ante una determinada operación
	 */
	@Test
	void CrearUsuarioTest() {
		Usuario user = new Usuario();

		//*PARAMETROS DE ENTRADA*//
		//->clave visible:                                  BD.POSTGRESQL.usuario.clave<-
//			user.setNombre("dog"); user.setClave("min"); user.setEnabled(true);				
//			user.setNombre("cat");  user.setClave("shu"); user.setEnabled(true);

		//->clave codificada spring-security:    BD.POSTGRESQL.usuario.clave<-
//			user.setNombre("bryan"); user.setClave(encoder.encode("database1")); user.setEnabled(true); //11
			user.setNombre("user2"); user.setClave(encoder.encode("database2")); user.setEnabled(true); //12


		//*PARAMETROS DE SALIDA*//
			Usuario userRetornado = iUsuarioRepo.save(user);
//			assertTrue(userRetornado.getClave().contentEquals(user.getClave()) );
			assertTrue(userRetornado.getClave().equalsIgnoreCase(user.getClave()) );
	}
	
	@Test
	void CrearListaUsuariosTest() {
		Usuario user1 = new Usuario();
		Usuario user2= new Usuario();
		user1.setNombre("bryan"); user1.setClave(encoder.encode("database1")); user1.setEnabled(true); //11
		user2.setNombre("user2"); user2.setClave(encoder.encode("database2")); user2.setEnabled(true); //12

		//*PARAMETROS DE ENTRADA*//		
		List<Usuario> list = Arrays.asList(user1, user2);

		//*PARAMETROS DE SALIDA*//
		list.stream().forEach((Usuario user) -> {
			Usuario userRetornado = iUsuarioRepo.save(user);
			assertTrue(userRetornado.getClave().equalsIgnoreCase(user.getClave()) );
		});

	}

}
