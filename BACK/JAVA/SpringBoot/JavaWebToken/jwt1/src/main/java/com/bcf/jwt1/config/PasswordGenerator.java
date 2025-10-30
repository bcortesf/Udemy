package com.bcf.jwt1.config;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "manager";
        String encondedPassword = encoder.encode(rawPassword);

        System.out.println(encondedPassword); //Esto dara el hash encriptado
    }
}
