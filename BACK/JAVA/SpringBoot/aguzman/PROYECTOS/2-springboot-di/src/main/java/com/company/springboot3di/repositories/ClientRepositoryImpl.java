package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.company.springboot3di.data.ClientData;
import com.company.springboot3di.models.Client;

@Repository
public class ClientRepositoryImpl implements IClientRepository {

    private ClientData data;

    public ClientRepositoryImpl(ClientData data) {
        this.data = data;
    }

    @Override
    public List<Client> findAll() {
        return this.data.getList();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return findAll().stream()
            .filter((Client p) -> p.getId().equals(id))
            .findFirst();
    }

}
