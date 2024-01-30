package com.company.springbootdifactura.services;

import java.util.List;

import com.company.springbootdifactura.models.Invoice;

public interface IInvoiceService {
    List<Invoice> findAll();
}
