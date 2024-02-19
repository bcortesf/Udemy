package com.company.jpa.entitys.dto;


public class PersonDto {

    private String name;
    private String programmingLanguage;


    public PersonDto(String name, String programmingLanguage) {
        this.name = name;
        this.programmingLanguage = programmingLanguage;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }


    @Override
    public String toString() {
        return "PersonDto [name=" + name + ", programmingLanguage=" + programmingLanguage + "]";
    }

}


