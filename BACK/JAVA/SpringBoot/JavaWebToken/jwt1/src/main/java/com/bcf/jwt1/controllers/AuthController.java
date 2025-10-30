package com.bcf.jwt1.controllers;


import com.bcf.jwt1.dto.AuthenticationRequest;
import com.bcf.jwt1.dto.AuthenticationResponse;
import com.bcf.jwt1.service.JwtService;
import com.bcf.jwt1.service.UserDetailsServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
@AllArgsConstructor
public class AuthController {

    private AuthenticationManager authenticationManager; //Autenticar-el-usuario-manualmente
    private UserDetailsServiceImpl userDetailsService; //carga-informacion-usuario-apartir-de-su-username: desde-la-BD
    private JwtService jwtService; //generar-token


    /**
     * Me va a generar el TOKEN, segun las credenciales del usuario (username, password)
     * @param request
     * @return
     */
    @PostMapping(path = "/login")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) {

        try {
            //autenticar las credenciales del usuario manualmente
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken( request.getUsername(), request.getPassword() )
            );
        } catch (AuthenticationException e) {
            // NO-EXISTE-EL-USUARIO
            // Retornar una respuesta 401, si las credenciales no son validas
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }


        final UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
        final String jwtToken = this.jwtService.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
    }

}
