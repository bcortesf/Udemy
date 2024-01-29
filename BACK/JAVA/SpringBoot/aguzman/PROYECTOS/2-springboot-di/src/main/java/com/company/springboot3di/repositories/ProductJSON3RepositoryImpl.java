package com.company.springboot3di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;

import com.company.springboot3di.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CONFIGURACION DE COMPONENTE EN CLASE @Configuration
 * src\main\java\com\company\springboot3di\configurations\ProductCONTconfiguration.java
 */

public class ProductJSON3RepositoryImpl  implements IProductRepository{
    private List<Product> list;

    //->   src\main\resources\json\product.json
    //->Lectura de archivo JSON
    public ProductJSON3RepositoryImpl(Resource resource) {
        ObjectMapper objMapper = new ObjectMapper();     //Convertir inputString o JSON -> a un objeto java
        try {
            //                                            (resource.getInputStream(), Product[].class)
            this.list = Arrays.asList( objMapper.readValue(resource.getFile(), Product[].class) );
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Product> findAll() {
        return this.list;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.list.stream()
            .filter((Product p ) -> p.getId().equals(id))
            .findFirst();
    }


    @Override
    public List<Product> findTaxAllSingleton() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllSingleton'");
    }
    @Override
    public List<Product> findTaxAllImmutabilityPrinciple() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllImmutabilityPrinciple'");
    }
    @Override
    public List<Product> findTaxAllRequestScope() {
        throw new UnsupportedOperationException("Unimplemented method 'findTaxAllRequestScope'");
    }

}
