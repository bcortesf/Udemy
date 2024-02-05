package com.company.manejoerror.services;

import java.util.List;
import java.util.Optional;

import com.company.manejoerror.models.domains.User;

public interface UserService {
    List<User> findAll();

    Optional<User> findById1(Long idUser);
    User findById2(Long idUser);
}
