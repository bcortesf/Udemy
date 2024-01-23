package com.company.springboot3web.repositories;

import org.springframework.stereotype.Repository;

@Repository
public class RequestParamRepository {

    public String convertToUpperCase(String message) {
        return message.toUpperCase();
    }
}
