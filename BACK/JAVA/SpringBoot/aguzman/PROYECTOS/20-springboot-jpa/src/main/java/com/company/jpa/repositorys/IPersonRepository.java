package com.company.jpa.repositorys;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.jpa.entitys.Person;
import com.company.jpa.entitys.dto.PersonDto;

import java.util.List;
import java.util.Optional;


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
    /* CREAR QUERYS POR NOMENCLATURA */

    //-> https://docs.spring.io/spring-data/jpa/reference/repositories/query-keywords-reference.html#appendix.query.method.subject
    List<Person> findByProgrammingLanguage(String programmingLanguage);
    Optional<Person> findByName(String name);
    //-> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.query-creation
    //-> https://stackoverflow.com/a/51473366/20912933
    List<Person> findByProgrammingLanguageAndName(String programmingLanguage, String name);
    Optional<Person> findByNameStartingWith(String name);


    //----------------------------------------------------------------------------------------------------------
    /* CREAR QUERYS POR QUERYS NATIVOS*/

    //-> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.at-query
    @Query("select p from Person p where p.programmingLanguage = ?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name);
    
    //->personalizar campos para un modelo DTO
    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonsData();
    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1")
    List<Object[]> obtenerPersonsData(String name);

    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);
    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);

}