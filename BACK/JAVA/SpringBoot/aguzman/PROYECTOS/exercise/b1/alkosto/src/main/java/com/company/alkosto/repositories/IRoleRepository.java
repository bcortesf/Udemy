package com.company.alkosto.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.company.alkosto.entities.Role;


public interface IRoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(String name);
}
