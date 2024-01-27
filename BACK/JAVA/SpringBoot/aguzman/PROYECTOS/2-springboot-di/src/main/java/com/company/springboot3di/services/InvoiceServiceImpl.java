package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Invoice;
import com.company.springboot3di.repositories.InvoiceRepositoryImpl;

@Service
public class InvoiceServiceImpl implements IInvoiceService {
    private InvoiceRepositoryImpl repository;

    public InvoiceServiceImpl(InvoiceRepositoryImpl repository) {
        this.repository = repository;
    }

    @Override
    public List<Invoice> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return this.repository.findById(id);
    }
}
