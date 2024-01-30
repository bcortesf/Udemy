package com.company.springbootdifactura.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.company.springbootdifactura.models.Invoice;
import com.company.springbootdifactura.repositorys.IInvoiceRepository;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    private IInvoiceRepository repository;

    public InvoiceServiceImpl(IInvoiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Invoice> findAll() {
        return this.repository.findAll();
    }

}
