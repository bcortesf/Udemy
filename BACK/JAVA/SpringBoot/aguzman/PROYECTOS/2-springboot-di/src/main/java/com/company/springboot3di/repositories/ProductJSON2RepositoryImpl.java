package com.company.springboot3di.repositories;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Product;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * CONFIGURACION DE COMPONENTE EN CLASE @Configuration
 * src\main\java\com\company\springboot3di\configurations\ProductCONTconfiguration.java
 */

@Repository
public class ProductJSON2RepositoryImpl  implements IProductRepository{
    private List<Product> list;

    //->inyeccion-por-contructor
    //->   src\main\resources\json\product.json
    @Value(value = "#{'classpath:json/product.json'}")
    private Resource resource;

    public ProductJSON2RepositoryImpl(){
        this.resource = new ClassPathResource("json/product.json"); //->Lectura de archivo JSON
        initList();
    }

    private void initList() {
        ObjectMapper objMapper = new ObjectMapper();     //Convertir inputString o JSON -> a un objeto java
        try {
            //                                            (resource.getInputStream(), Product[].class)
            this.list = Arrays.asList( objMapper.readValue(this.resource.getFile(), Product[].class) );
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
