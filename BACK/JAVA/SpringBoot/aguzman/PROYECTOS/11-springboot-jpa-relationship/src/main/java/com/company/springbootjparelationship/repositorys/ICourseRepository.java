package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Course;


public interface ICourseRepository extends CrudRepository<Course, Long> {

    /*
     * findBy< Course."Nombre-atributo" >
     */
    Optional<Course> findByName(String name);


    @Query(value = "select c from Course c left join fetch c.students where c.name=?1")
    Optional<Course> findOneCourseNameWithStudents(String nameCourse);
}
