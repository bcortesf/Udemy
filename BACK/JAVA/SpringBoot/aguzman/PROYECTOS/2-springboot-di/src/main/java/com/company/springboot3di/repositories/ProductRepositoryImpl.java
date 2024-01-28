package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.company.springboot3di.data.ProductData;
import com.company.springboot3di.models.Product;

@Primary
@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private ProductData data;

    public ProductRepositoryImpl(ProductData data) {
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

    @Override
    public List<Product> findTaxAll() {
        /*
         * NUEVAS INSTANCIAS POR CADA PETICION, PRINCIPIO-INMUTABILIDAD
        */
        /*    FORMA-1: PRINCIPIO-INMUTABILIDAD + <Product>.clone()    */
        return this.findAll().stream()
            .map((Product p) -> {
                Double priceTax = p.getPrice() + (p.getPrice() * 0.21);
                String nameUpper = p.getName().toUpperCase();
                Product newCloneProduct = (Product)p.clone(); //->Datos CLONES "POR-VALOR"; y <NO-POR-REFENCIA-INSTANCIA>
                    newCloneProduct.setName(nameUpper);
                    newCloneProduct.setPrice(priceTax);
                return newCloneProduct;
            }).collect(Collectors.toList());

        /*          FORMA-2: PRINCIPIO-INMUTABILIDAD       */
        // return this.findAll().stream()
        //     .map((Product p) -> {
        //         Double priceTax = p.getPrice() + (p.getPrice() * 0.21);
        //         String nameUpper = p.getName().toUpperCase();
        //         return new Product(p.getId(), nameUpper, priceTax);
        //     }).collect(Collectors.toList());

        /*          FORMA-3: PRINCIPIO-INMUTABILIDAD       */
        // ProductData dataNEW = new ProductData();
        // return dataNEW.getList().stream()
        //     .map((Product p) -> {
        //         Double tax = p.getPrice() * 0.21;
        //         p.setPrice( p.getPrice() + tax );
        //         p.setName(p.getName().toUpperCase());
        //         return p;
        //     }).collect(Collectors.toList());

        //-----------------------------------------------------
        //-----------------------------------------------------

        /*
         * MODIFICA AL SERVICIO FIND-ALL, PORQUE ES SINGLETON, MUTABLE
        */
        /*                FORMA-1: SINGLETON                */
        // return this.data.getList().stream()
        //     .map((Product p) -> {
        //         Double tax = p.getPrice() * 0.21;
        //         p.setPrice( p.getPrice() + tax );
        //         return p;
        //     }).collect(Collectors.toList());

        /*                FORMA-2: SINGLETON                */
        // return findAll().stream()
        //     .map((Product p) -> {
        //         Double tax = p.getPrice() * 0.21;
        //         p.setPrice( p.getPrice() + tax );
        //         return p;
        //     }).collect(Collectors.toList());
        //-----------------------------------------------------
    }

}
