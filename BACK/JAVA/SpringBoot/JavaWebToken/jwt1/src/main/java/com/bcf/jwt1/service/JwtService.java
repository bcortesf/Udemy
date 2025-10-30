package com.bcf.jwt1.service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    @Value(value = "${jwt.secret}")
    private String SECRET_KEY;

    @Value(value = "${jwt.expiration}")
    private long expirationTimeInMillis;


    /**
     * POM(io.jsonwebtoken)
     * En la versión 0.12.0+, el método signWith(Key key) automáticamente determina el algoritmo basado en la clave proporcionada.
     *
     * Ahora solo se pasa la clave, sin necesidad de indicar SignatureAlgorithm.
     * HS256, ya que el algoritmo se deduce automáticamente.
        .signWith(
            Keys.hmacShaKeyFor(SECRET_KEY.getBytes())
            ,SignatureAlgorithm.HS256
        )
     *
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date()) //emitido en
                .expiration(new Date(System.currentTimeMillis() + expirationTimeInMillis))
                .signWith(
                        Keys.hmacShaKeyFor(SECRET_KEY.getBytes())
                        //,SignatureAlgorithm.HS256
                )
                .compact();
    }
}
