package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Product;
import com.company.springboot3di.repositories.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
    private IProductRepository repository;

    /**
     */
    public ProductServiceImpl(
            /*OPCION-1: Dejar el principal: <ProductPrimaryRepositoryImpl.class> */
            // IProductRepository repository   //->configurado por @Primary

            /*------------------------------------------------------------*/

            /*OPCION-2: Tomar componenteJSON: <ProductJSONRepositoryImpl.class> */
            @Qualifier(value = "productJSON2RepositoryImpl") //->@Configuration-@Bean-@Qualifier.
            IProductRepository repository
    ) {
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

    /* ->SCOPE:  Tradicional java puro */
    @Override
    public List<Product> findTaxAllSingleton() {
        return this.repository.findTaxAllSingleton();
    }
    @Override
    public List<Product> findTaxAllImmutabilityPriciple() {
        return this.repository.findTaxAllImmutabilityPrinciple();
    }
    /* ->SCOPE:  Nuevo springBoot */
    @Override
    public List<Product> findTaxAllRequestScope() {
        return this.repository.findTaxAllRequestScope();
    }
}
