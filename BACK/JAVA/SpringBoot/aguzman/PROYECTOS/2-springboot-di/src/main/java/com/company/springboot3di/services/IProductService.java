package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import com.company.springboot3di.models.Product;

public interface IProductService {
    public List<Product> findAll();
    public Optional<Product> findById(Long id);

    public List<Product> findTaxAllSingleton();
    public List<Product> findTaxAllImmutabilityPriciple();
}
