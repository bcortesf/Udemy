package com.company.springboot3web.controllers.request;

import java.util.Arrays;

/**
 * Se pob;a de forma automatica, mediante:
 *  -Un constructor vacio
 *  -metodos setters
 */
public class UserRequest {
    private Long nit;
    private String name;
    private String[] contactNumbers;

    public Long getNit() {
        return nit;
    }
    public void setNit(Long nit) {
        this.nit = nit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String[] getContactNumbers() {
        return contactNumbers;
    }
    public void setContactNumbers(String[] contactNumbers) {
        this.contactNumbers = contactNumbers;
    }

    @Override
    public String toString() {
        return "UserRequest [nit=" + nit + ", name=" + name + ", contactNumbers=" + Arrays.toString(contactNumbers)
                + "]";
    }
}

