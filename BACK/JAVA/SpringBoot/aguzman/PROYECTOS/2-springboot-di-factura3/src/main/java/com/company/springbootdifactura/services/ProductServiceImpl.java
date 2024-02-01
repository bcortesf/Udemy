package com.company.springbootdifactura.services;

import org.springframework.stereotype.Service;

import com.company.springbootdifactura.models.Product;
import com.company.springbootdifactura.repositorys.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
    private IProductRepository repository;


    public ProductServiceImpl(IProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product findById(Long idProduct) {
        return this.repository.findById(idProduct);
    }

}
