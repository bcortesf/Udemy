package com.company.springbootjparelationship.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.ClientDetails;



public interface IClientDetailsRepository extends CrudRepository<ClientDetails, Long> {

}
