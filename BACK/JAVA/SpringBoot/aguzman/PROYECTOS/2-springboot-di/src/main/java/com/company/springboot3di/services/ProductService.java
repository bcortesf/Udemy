package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Product;
import com.company.springboot3di.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> findAll() {
        return this.repository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return this.repository.findById(id);
    }

    public List<Product> findTaxAll() {
        return this.repository.findTaxAll();
    }
}
