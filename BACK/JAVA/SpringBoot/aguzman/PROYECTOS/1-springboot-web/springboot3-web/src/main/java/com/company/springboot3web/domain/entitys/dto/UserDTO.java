package com.company.springboot3web.domain.entitys.dto;

import org.springframework.stereotype.Component;

@Component
public class UserDTO {

    private String name;
    private String lastName;

    /**
     * Solo devuelvo el modelo personalizado segun esta clase"UserDTO"
     * @param name
     * @param lastName
     * @return
     */
    public Object getUserDTO(String name, String lastName) {
        setName(name);
        setLastName(lastName);
        return this;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
