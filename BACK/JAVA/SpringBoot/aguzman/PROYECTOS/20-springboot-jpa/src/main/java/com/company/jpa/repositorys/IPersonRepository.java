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
    /* CREAR QUERYS POR QUERYS NATIVOS  :LISTAS*/

    //-> https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html#jpa.query-methods.at-query
    @Query("select p from Person p where p.programmingLanguage = ?1")
    List<Person> buscarByProgrammingLanguage(String programmingLanguage);
    @Query("select p from Person p where p.programmingLanguage=?1 and p.name=?2")
    List<Person> buscarByProgrammingLanguageAndName(String programmingLanguage, String name);
    
    /* CREAR QUERYS POR QUERYS NATIVOS  :DESARMAR OBJETO Y PARTIRLO EN VARIOS CAMPOS*/
    @Query("select p.name, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonsDataList();
    @Query("select p.name, p.programmingLanguage from Person p where p.name=?1")
    List<Object[]> obtenerPersonsDataList(String name);
    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMixPersonsDataList();


    @Query("select p from Person p")
    List<Person> findAllEntityPerson();
    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllEntityPersonByFiedls();
    /*            ----         DTO: <PACKAGE> + <CLASS-NAME>        ----          */
    @Query("select new com.company.jpa.entitys.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllClassPersonDTO();


    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Object obtenerPersonDataFullObjById(Long id);
    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id=?1")
    Optional<Object> obtenerPersonDataFullOptById(Long id);


    @Query("select p from Person p where p.id=?1")
    Optional<Person> findOne(Long id);
    @Query("select p from Person p where p.name=?1")
    Optional<Person> findOneName(String name);
    @Query("select p from Person p where p.name like %?1%")
    Optional<Person> findOneLikeName(String name);


    /* CREAR QUERYS POR JPQL:  TIPO DE DATO - CAMPOS PERSONALIZADOS */
    @Query("select p.name from Person p where p.id=?1")
    String getNameById(Long id);
    @Query("select p.id from Person p where p.id=?1")
    Long getIdById(Long id);
    @Query("select concat(p.name, ' ',  p.lastname) as fullName from Person p where p.id=?1")
    String getFullNameById(Long id);

}