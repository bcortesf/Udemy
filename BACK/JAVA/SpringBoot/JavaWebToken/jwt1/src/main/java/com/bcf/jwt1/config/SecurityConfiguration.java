package com.bcf.jwt1.config;

import com.bcf.jwt1.service.UserDetailsServiceImpl;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@AllArgsConstructor
public class SecurityConfiguration {

    //Hace la carga delos usuarios, apartir de la base de datos
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Value(value = "${jwt.secret}")
    private String secretKey;


    /**
     * las rutas o paths que se configuran aqui, estna mapeadas en
     * package com.bcf.jwt1.controllers;
     *      [ApiController.class,  AuthController.class]
     *
     * @param http
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable) //Deshabilitar CSRF en la nueva versión
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/public").permitAll()

                        .requestMatchers("/auth/login").permitAll()         //Public
                        .requestMatchers("/api/private").hasRole("ADMIN")   //Basic Auth
                        .requestMatchers("/api/manager").hasRole("MANAGER") //
                        .requestMatchers("/api/admin").authenticated()      //JWT Protected
                )
                .httpBasic(Customizer.withDefaults())  //Configurar Basic Auth
                .oauth2ResourceServer(oauth -> oauth
                        .jwt(jwtConfigurer -> jwtConfigurer
                                .decoder(jwtDecoder())
                        )
                );

        return http.build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withSecretKey(
                new SecretKeySpec(secretKey.getBytes(), SignatureAlgorithm.HS256.getJcaName())
        ).build();
    }


    //------------------------------------------------------------------------------------------------------------------
    /*AuthorizationBasic*/

    /**
     * Se usa para la carga manual de los usuarios
     * @param authConfig
     * @return
     * @throws Exception
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    /**
     * authProvider.setUserDetailsService(userDetailsServiceImpl);
     *  -   Es el que va utilizarse en la base de datos, mediante el metodo:
     *      userDetailsServiceImpl.loadUserByUsername(username)
     *
     * @return
     */
    @Bean
    public  DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsServiceImpl);
        authProvider.setPasswordEncoder( passwordEncoder() );
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
