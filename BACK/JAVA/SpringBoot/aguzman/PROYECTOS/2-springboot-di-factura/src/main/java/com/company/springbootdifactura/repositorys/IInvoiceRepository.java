package com.company.springbootdifactura.repositorys;

import java.util.List;

import com.company.springbootdifactura.models.Invoice;

public interface IInvoiceRepository {
    List<Invoice> findAll();
}
