package com.company.alkosto.services;

import java.util.List;

import com.company.alkosto.entities.User;

public interface IUserService {
    /*
     * TODO: List<UserDTO> findAll();
     * Intentar devolverlo, quindo los ROLES
     */
    List<User> findAll();

    User save(User user);
}
