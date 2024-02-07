package com.company.jpa.entitys;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "persons") //mismo nombre tabla DB
public class Person {

    @Id
    @GeneratedValue(    //strategy="autoincrementable"
        // strategy = GenerationType.SEQUENCE //BD(PostgreSQL, Oracle)
        strategy = GenerationType.IDENTITY    //BD(MySQL, SQL-Server)
    )
    private Long id;
    private String name;
    private String lastname;
    @Column(name = "programming_language") //bd.campo.nombre
    private String programmingLanguage;


    public Person() {
        //->CONSTRUCTOR "OBLIGATORIO" <JPA, HIBERNATE>
        //->    -PARA (INSTANCIAS, POBLAR-DATOS-TABLA, PERSISTENCIA)
    }
    public Person(Long id, String name, String lastname, String programmingLanguage) {
        //->constructor para nosotros, PERSONALIZADO
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programmingLanguage;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getProgrammingLanguage() {
        return programmingLanguage;
    }
    public void setProgrammingLanguage(String programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public String toString() {
        return "[id=" + id + ", name=" + name + ", lastname=" + lastname + ", programmingLanguage="
                + programmingLanguage + "]";
    }

}


/*
@Entity
@Table(name = "Person") //mismo nombre tabla DB
public class Person {}



@Entity
public class Person {}
*/