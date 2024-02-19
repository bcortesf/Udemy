package com.company.springbootjparelationship.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Client;

public interface IClientRepository extends CrudRepository<Client, Long> {
    
}
