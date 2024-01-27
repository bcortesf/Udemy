package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Product;
import com.company.springboot3di.repositories.ProductRepositoryImpl;

@Service
public class ProductServiceImpl implements IProductService {
    private ProductRepositoryImpl repository;

    public ProductServiceImpl(ProductRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll() {
        return this.repository.findAll();
    }
    @Override
    public Optional<Product> findById(Long id) {
        return this.repository.findById(id);
    }
    @Override
    public List<Product> findTaxAll() {
        return this.repository.findTaxAll();
    }
}
