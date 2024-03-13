package com.company.springbootjparelationship.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Course;


public interface ICourseRepository extends CrudRepository<Course, Long> {

}
