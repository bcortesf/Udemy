package com.company.springboot3di.repositories;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.company.springboot3di.models.Product;


@Repository
public class ProductSecondRepositoryImpl implements IProductRepository {

    private static final String MENSAJE_TRISTE = " \"JAJAJA TRISTE :'( \" ........................";

    @Override
    public List<Product> findAll() {
        return Collections.singletonList(new Product(1L, "Silla Gamer", 1200000));
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.of(new Product(id, "Silla Gamer", 1200000));
    }

    @Override
    public List<Product> findTaxAllSingleton() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllSingleton'".concat(MENSAJE_TRISTE));
    }

    @Override
    public List<Product> findTaxAllImmutabilityPrinciple() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllImmutabilityPrinciple'".concat(MENSAJE_TRISTE));
    }

    @Override
    public List<Product> findTaxAllRequestScope() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllRequestScope'".concat(MENSAJE_TRISTE));
    }

}
