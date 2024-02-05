package com.company.manejoerror.configurations;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.company.manejoerror.models.domains.User;

@Configuration
public class UserConfiguration {

    @Bean
    List<User> getListUsers(){
        return Arrays.asList(
            new User(1L, "Bryan1", "CFz-1"),
            new User(2L, "Bryan2", "CFz-2"),
            new User(3L, "Bryan3", "CFz-3"),
            new User(4L, "Bryan4", "CFz-4")
        );
    }
}
