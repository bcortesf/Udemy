package com.company.springboot3web.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.company.springboot3web.data.PathVariableData;
import com.company.springboot3web.domain.entitys.User;

@Repository
public class PathVariableRepository {

    @Autowired
    private PathVariableData data;

    public List<User> getListUser() {
        return data.getList();
    }

    public Optional<User> getUser(Integer idUsuario){
        return getListUser().stream()
            .filter((User u) -> u.getId().equals(idUsuario))
            .findFirst();
    }
}
