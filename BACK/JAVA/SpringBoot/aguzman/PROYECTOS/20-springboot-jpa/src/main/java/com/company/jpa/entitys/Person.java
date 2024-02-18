package com.company.jpa.entitys;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreRemove;
import jakarta.persistence.PreUpdate;
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
    @Column(name = "programming_language") //MYSQL:(bd->campo->nombre)
    private String programmingLanguage;
    private LocalDate birthdate;

    /*MANEJAR TABLA<Person> PARA:   TRAZAR(Trazabililidad) ó AUDITAR(Auditoria) */
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;


    public Person() {
        //->CONSTRUCTOR "OBLIGATORIO" <JPA, HIBERNATE>
        //->    -PARA (INSTANCIAS, POBLAR-DATOS-TABLA, PERSISTENCIA)
    }
    public Person(Long id, String name, String lastname, String programmingLanguage, LocalDate birthdate) {
        //->constructor para nosotros, PERSONALIZADO
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.programmingLanguage = programmingLanguage;
        this.birthdate = birthdate;
    }
    public Person(String name, String programmingLanguage) {
        /* Usado en: src\main\java\com\company\jpa\repositorys\IPersonRepository.java
         * * List<Person[]> findAllClassPerson();
         */
        this.name = name;
        this.programmingLanguage = programmingLanguage;
    }


    @PrePersist
    public void prePersist() {
        System.out.println("evento del CICLO-DE-VIDA del entity: pre-persist");
        this.createdAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate() {
        System.out.println("evento del CICLO-DE-VIDA del entity: pre-update");
        this.updatedAt =  LocalDateTime.now();
    }
    @PreRemove
    public void preRemove() {
        System.out.println("evento del CICLO-DE-VIDA del entity: pre-remove");
        this.deletedAt = LocalDateTime.now();
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
    public LocalDate getBirthdate() {
        return birthdate;
    }
    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }


    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", lastname=" + lastname + ", programmingLanguage="
                + programmingLanguage + ", birthdate=" + birthdate + "]";
    }
}


/*
@Entity
@Table(name = "Person") //mismo nombre tabla DB
public class Person {}



@Entity
public class Person {}
*/