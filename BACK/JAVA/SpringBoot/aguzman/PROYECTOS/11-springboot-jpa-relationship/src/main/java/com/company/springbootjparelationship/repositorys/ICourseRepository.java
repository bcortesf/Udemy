package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Course;


public interface ICourseRepository extends CrudRepository<Course, Long> {

    /*
     * findBy< Student."Nombre-atributo" >
     */
    Optional<Course> findByName(String name);
}
