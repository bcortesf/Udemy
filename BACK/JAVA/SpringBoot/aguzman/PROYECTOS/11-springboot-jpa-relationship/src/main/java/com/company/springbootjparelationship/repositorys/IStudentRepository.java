package com.company.springbootjparelationship.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Student;


public interface IStudentRepository extends CrudRepository<Student, Long> {

}