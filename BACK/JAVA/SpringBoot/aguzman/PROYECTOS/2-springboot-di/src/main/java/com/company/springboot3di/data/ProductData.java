package com.company.springboot3di.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.company.springboot3di.models.Product;

@Component
public class ProductData {
    private final List<Product> list;

    public ProductData() {
        this.list = Arrays.asList(
            new Product(1L, "productoA", 1.1),
            new Product(2L, "productoB", 2.2),
            new Product(3L, "productoC", 3.3)
        );
    }

    public List<Product> getList() {
        return list;
    }

}
