package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import com.company.springboot3di.models.Product;

public interface IProduct {
    public List<Product> findAll();
    public Optional<Product> findById(Long id);
}
