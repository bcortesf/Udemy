package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Client;

public interface IClientRepository extends CrudRepository<Client, Long> {
    /** https://www.arquitecturajava.com/jpa-join-fetch-uso/
     * .
     */

    @Query(value = "select c from Client c join fetch c.direcciones")
    Optional<Client> findOne(Long idCliente);
}
