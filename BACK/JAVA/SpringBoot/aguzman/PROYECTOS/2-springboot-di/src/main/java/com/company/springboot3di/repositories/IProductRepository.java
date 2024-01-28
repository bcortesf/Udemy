package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import com.company.springboot3di.models.Product;

public interface IProductRepository {
    public List<Product> findAll();
    public Optional<Product> findById(Long id);

    /* ->SCOPE:  Tradicional java puro */
    public List<Product> findTaxAllSingleton();
    public List<Product> findTaxAllImmutabilityPrinciple();
    /* ->SCOPE:  Nuevo springBoot */
    public List<Product> findTaxAllRequestScope();

}
