package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Student;


public interface IStudentRepository extends CrudRepository<Student, Long> {

    /*
     * findBy< Student."Nombre-atributo" >
     */
    Optional<Student> findByName(String name);

    @Query(value = "select s from Student s left join fetch s.courses where s.name=?1")
    Optional<Student> findOneStudentNameWithCourses(String name);

    @Query(value = "select s from Student s left join fetch s.courses where s.id=?1")
    Optional<Student> findOneStudentIdWithCourses(Long idStudent);

}