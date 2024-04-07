package com.company.alkosto.repositories;

import org.springframework.data.repository.CrudRepository;

import com.company.alkosto.entities.User;

public interface IUserRepository extends CrudRepository<User, Long> {

}
