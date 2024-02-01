package com.company.springbootdifactura.services;

import java.util.List;

import com.company.springbootdifactura.models.Invoice;

public interface IInvoiceService {
    public List<Invoice> findAll();
    //
    String  buildInvoiceStringCOMPONENT();
    Invoice buildInvoiceCOMPONENT();
}
