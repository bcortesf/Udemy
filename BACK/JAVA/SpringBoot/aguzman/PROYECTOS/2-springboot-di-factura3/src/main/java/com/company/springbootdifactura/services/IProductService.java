package com.company.springbootdifactura.services;

import com.company.springbootdifactura.models.Product;

public interface IProductService {
    Product findById(Long idProduct);
}
