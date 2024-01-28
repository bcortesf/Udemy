package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.company.springboot3di.data.ProductData;
import com.company.springboot3di.data.ProductDataRequestScope;
import com.company.springboot3di.models.Product;



@Primary
@Repository
public class ProductPrimaryRepositoryImpl implements IProductRepository {
    Logger log = LoggerFactory.getLogger(getClass());
    //->Lectura1:  desde "invoice.properties" en: <ProductCONTconfiguration.class>
    @Value(value = "${repository.product.tax}")
    private Double tax21porCien;
    //->Lectura2:  desde "invoice.properties" en: <ProductCONTconfiguration.class>
    @Autowired private  Environment enviroment;



    private ProductData data;
    private ProductDataRequestScope dataRequestScope;

    public ProductPrimaryRepositoryImpl(ProductData data, ProductDataRequestScope dataRequestScope) {
        this.data = data;
        this.dataRequestScope = dataRequestScope;
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

    /* ->SCOPE:  Tradicional java puro */
    /*_____________________________________________________________________________________________ */
    /**
     **       SINGLETON    VS    PRINCIPIO-INMUTABILIDAD
     *
     * SINGLETON:                   "Mutable"
     * * Modifica al servicio por cada peticion HTTP-request. (datos-permanecen en memoria)
     * IMMUTABILITY-PRINCIPLE:      "Inmutable"
     * * Generar nuevas instancias por cada peticion HTTP-request. (datos-nuevos ó datos-reiniciados)
     */
    @Override
    public List<Product> findTaxAllSingleton() {
        /*                FORMA-1: SINGLETON                */
        return this.data.getList().stream()
            .map((Product p) -> {
                Double tax = p.getPrice() * 0.21;
                p.setPrice( tax );  //  ( p.getPrice() + tax )
                return p;
            }).collect(Collectors.toList());

        /*                FORMA-2: SINGLETON                */
        // return findAll().stream()
        //     .map((Product p) -> {
        //         Double tax = p.getPrice() * 0.21;
        //         p.setPrice( p.getPrice() + tax );
        //         return p;
        //     }).collect(Collectors.toList());
    }

    @Override
    public List<Product> findTaxAllImmutabilityPrinciple() {
        /*    FORMA-1: <Product>.clone()    */
        return this.findAll().stream()
            .map((Product p) -> {
                Double priceTax = p.getPrice() + (p.getPrice() * 0.21);
                String nameUpper = p.getName().toUpperCase();
                Product newCloneProduct = (Product)p.clone(); //->Datos CLONES "POR-VALOR"; y <NO-POR-REFENCIA-INSTANCIA>
                    newCloneProduct.setName(nameUpper);
                    newCloneProduct.setPrice(priceTax);
                return newCloneProduct;
            }).collect(Collectors.toList());

        /*          FORMA-2: retorno "new product()" interno en el map       */
        // return this.findAll().stream()
        //     .map((Product p) -> {
        //         Double priceTax = p.getPrice() + (p.getPrice() * 0.21);
        //         String nameUpper = p.getName().toUpperCase();
        //         return new Product(p.getId(), nameUpper, priceTax);
        //     }).collect(Collectors.toList());

        /*          FORMA-3: retorno "new product()" antes del map       */
        // ProductData dataNEW = new ProductData();
        // return dataNEW.getList().stream()
        //     .map((Product p) -> {
        //         Double tax = p.getPrice() * 0.21;
        //         p.setPrice( p.getPrice() + tax );
        //         p.setName(p.getName().toUpperCase());
        //         return p;
        //     }).collect(Collectors.toList());
    }
    /*_____________________________________________________________________________________________ */
    /* ->SCOPE:  Nuevo springBoot */
    @Override
    public List<Product> findTaxAllRequestScope() {
        //-> porque el componente tiene un alcance RequestScope, en "dataRequestScope"
        return this.dataRequestScope.getList().stream()
        .map((Product p) -> {
            //->Lectura desde "invoice.properties":  <tax1, tax2>
            Double tax1 = p.getPrice() * tax21porCien; 
            Double tax2 = p.getPrice() * Double.valueOf( enviroment.getProperty("repository.product.tax", "0") );

            p.setPrice( p.getPrice() + tax1 );
            p.setPrice( tax2 );
            return p;
        }).collect(Collectors.toList());
    }

}
