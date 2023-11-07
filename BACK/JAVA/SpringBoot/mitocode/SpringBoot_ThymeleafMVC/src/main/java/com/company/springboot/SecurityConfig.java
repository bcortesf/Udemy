package com.company.springboot;



import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * https://www.youtube.com/watch?v=ksLYIavT2L0&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&t=263s
 * https://www.youtube.com/watch?v=zQjZFHo8eO4&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&index=11
 * https://www.youtube.com/watch?v=zQjZFHo8eO4&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&index=12
 * Encriptar las claves de la clase<Usuario>.clave
 */

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
//	@Autowired
//	private UserDetailsServiceImpl usuarioService;
	//@Autowired private BCryptPasswordEncoder bcrypt;

    // https://www.youtube.com/watch?v=ksLYIavT2L0&list=PLvimn1Ins-40wR4PC-YtTQ5TKt3vRrVwl&t=438s
    //Declarar y tener una instancia de ambito singleton, en el core container spring.
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		return bCryptPasswordEncoder;
	}

}
