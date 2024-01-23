package com.company.springboot3web.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springboot3web.domain.entitys.User;
import com.company.springboot3web.repositories.PathVariableRepository;

@Service
public class PathVariableService {
    @Autowired
    private PathVariableRepository repository;

    public List<User> getListUser() {
        return repository.getListUser();
    }

    public Optional<User> getUser(Integer idUsuario){
        return repository.getUser(idUsuario);
    }
}
