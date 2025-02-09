package com.company.alkosto.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    /**
     * <groupId>org.springframework.boot</groupId>
	 * <artifactId>spring-boot-starter-security</artifactId>
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**                 **PERMISOS-ENDPONTS-USERCONTROLLER**
     * Filtro donde va a validar:
     * - los request, - va autorizar, - va a dar permisos, - va a denegar permisos, etc
     * HttpSecurity: inyectado automaticamente
     * @throws Exception
     * 
     * UserController -> PERFIL<Administrador> -> PostMapping Create
     *      - Un usuario "No-registrado, No-logeado" no tiene acceso
     */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests( (authorize) ->  authorize
            //->Permitir todo de : UserController: ES PUBLICO
                // .requestMatchers("/api/users").permitAll()                                   //->METODO-PRIVADO - GET_<ADMINISTRADOR>
                .requestMatchers(HttpMethod.GET,"/api/users").permitAll()           //->METODO-PRIVADO - GET_<ADMINISTRADOR>
                .requestMatchers(HttpMethod.POST,"/api/users/register").permitAll() //->METODO-PUBLICO - POST_<USUARIO>
            //->Denegar otro recurso o rutas de otro controlador
            //-> - porque debe estar autenticado
                .anyRequest().authenticated()
        )
        //Customiza, porque es un TOKEN valor-secreto-unico
        .csrf( config -> config.disable() ) //porque es un APIREST, caso contrario es para vistas(JSP, THYMELEAF,...etc)
        .sessionManagement( management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //guarda en sesionHTTP sin-estado o guarda en el TOKEN
        .build();
    }
}
