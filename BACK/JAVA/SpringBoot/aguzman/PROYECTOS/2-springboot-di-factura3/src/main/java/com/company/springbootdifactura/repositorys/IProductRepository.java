package com.company.springbootdifactura.repositorys;

import com.company.springbootdifactura.models.Product;

public interface IProductRepository {
    Product findById(Long idProduct);
}