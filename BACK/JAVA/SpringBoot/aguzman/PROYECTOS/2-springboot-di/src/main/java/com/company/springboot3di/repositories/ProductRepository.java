package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.company.springboot3di.data.ProductData;
import com.company.springboot3di.models.Product;

@Repository
public class ProductRepository implements IProduct {

    private ProductData data;

    public ProductRepository(ProductData data) {
        this.data = data;
    }

    @Override
    public List<Product> findAll() {
        return this.data.getList();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return findAll().stream()
            .filter((Product p) -> p.getId().equals(id))
            .findFirst();
    }

}
