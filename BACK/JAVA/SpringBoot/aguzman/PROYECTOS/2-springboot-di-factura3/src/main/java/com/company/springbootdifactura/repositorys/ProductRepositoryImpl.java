package com.company.springbootdifactura.repositorys;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.springbootdifactura.models.Invoice;
import com.company.springbootdifactura.models.InvoiceItem;
import com.company.springbootdifactura.models.Product;

@Repository
public class ProductRepositoryImpl implements IProductRepository {
    Logger log = LoggerFactory.getLogger(getClass());
    private IInvoiceRepository repositoryInv;

    public ProductRepositoryImpl(IInvoiceRepository repositoryInv) {
        this.repositoryInv = repositoryInv;
    }

    /*
     * ESTAS SINTAXIS SON IGUALES
     * .map((InvoiceItem invoiceItem) -> invoiceItem.getProduct())      :por expresion-lambda
     * .map((InvoiceItem::getProduct))                                  :por method-reference
     */
    @Override
    public Product findById(Long idProduct) {
        Product product =
        this.repositoryInv.findAll().get(0).getItems().stream()
            .filter((InvoiceItem invoiceItem) -> invoiceItem.getProduct().getId().equals(idProduct))
            .map((InvoiceItem::getProduct)) //->convert: <Product>
            .findFirst().orElse(new Product());

        log.info("PRUEBA: \n obj: {}", product);
        return product;
    }

    ////////////////////////////////////////
    /*PRUEBAS FUNCIONALES */
    public Product findById2(Long idProduct) {
        final Product product = new Product();

        this.repositoryInv.findAll().stream()
        .forEach((Invoice invoice) -> {
            Optional<Product> optProduct =
                invoice.getItems().stream()
                .filter((InvoiceItem invoiceItem) -> invoiceItem.getProduct().getId().equals(idProduct))
                .findFirst()
                .map( InvoiceItem::getProduct);

            if (!optProduct.isEmpty()) {
                Product productFOR = (Product)optProduct.get().clone();
                product.setId(productFOR.getId());
                product.setName(productFOR.getName());
                product.setExpirationDate(productFOR.getExpirationDate());
            }
        });

        return product;
    }

}
