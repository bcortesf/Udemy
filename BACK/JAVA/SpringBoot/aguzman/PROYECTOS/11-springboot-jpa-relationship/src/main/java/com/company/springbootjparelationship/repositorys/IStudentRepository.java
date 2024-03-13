package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Student;


public interface IStudentRepository extends CrudRepository<Student, Long> {

    /*
     * findBy< Student."Nombre-atributo" >
     */
    Optional<Student> findByName(String name);
}