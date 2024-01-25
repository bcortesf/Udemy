package com.company.springboot3web.domain.entitys.dto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.company.springboot3web.domain.entitys.User;

@Component
public class UserTest1DTO {

    private User user;
    
    public UserTest1DTO(@Autowired User user){
        this.user = user;
    }

    /**
     * Devolver TODAS propiedades.<Usuario."KEYS">;
     * Establecer los <Usuario."VALUES"> con valor
     *      - Los <Usuario."VALUES"> sin valor, tendran un valor NULL
     * @param userFind
     * @return
     */
    public Object getUserTestDTO(User userFind) {
        user.setName(userFind.getName());
        user.setLastName(userFind.getLastName());
        return user;
    }
}
