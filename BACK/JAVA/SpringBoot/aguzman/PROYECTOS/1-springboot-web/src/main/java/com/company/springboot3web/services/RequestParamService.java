package com.company.springboot3web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.springboot3web.repositories.RequestParamRepository;

@Service
public class RequestParamService {

    @Autowired
    private RequestParamRepository repository;

    public String convertToUpperCase(String message) {
        return repository.convertToUpperCase(message);
    }

}
