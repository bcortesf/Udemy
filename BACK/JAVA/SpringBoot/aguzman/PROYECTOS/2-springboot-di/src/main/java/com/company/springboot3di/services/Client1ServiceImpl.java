package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Client;
import com.company.springboot3di.repositories.IClientRepository;

@Primary
@Service(value = "client1ServiceImpl")
public class Client1ServiceImpl implements IClientService {
    private IClientRepository repository;

    public Client1ServiceImpl(
            @Qualifier(value = "client1RepositoryImpl") IClientRepository repository) {
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
