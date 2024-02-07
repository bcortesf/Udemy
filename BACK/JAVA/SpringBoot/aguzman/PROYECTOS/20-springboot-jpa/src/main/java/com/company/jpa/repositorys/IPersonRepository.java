package com.company.jpa.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.jpa.entitys.Person;
import java.util.List;


/**
 * PersonRepository === PersonDao
 * ----------------------------------------
 *               <Class , Class.PrimaryKey>
 * CrudRepository<Person, Long ID         >
 * ----------------------------------------
 * AL NAVEGAR EN "CrudRepository" VEMOS QUE:
 * - es un componente ->@NoRepositoryBean
 *
 * POR LO TANTO "IPersonRepository": SE CONVIERTE EN COMPONENTE
 */
public interface IPersonRepository extends CrudRepository<Person, Long> {
    //->CREAR QUERYS PERSONALIZADAS POR CAMPOS
    
    //-> https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html#appendix.query.method.subject
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    //-> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);


    //-> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.at-query
    @Query("select p from Person p where p.programmingLanguage = ?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name);
}