package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Client;
import com.company.springboot3di.repositories.IClientRepository;

@Service(value = "client2ServiceImpl")
public class Client2ServiceImpl implements IClientService {
    private IClientRepository repository;

    public Client2ServiceImpl(
            @Qualifier(value = "client2RepositoryImpl") IClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Client> findById(Long id) {
        return this.repository.findById(id);
    }

}
