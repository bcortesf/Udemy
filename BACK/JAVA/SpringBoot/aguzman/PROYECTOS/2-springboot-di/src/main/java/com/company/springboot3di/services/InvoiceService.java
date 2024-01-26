package com.company.springboot3di.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.company.springboot3di.models.Invoice;
import com.company.springboot3di.repositories.InvoiceRepository;

@Service
public class InvoiceService {
    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public List<Invoice> findAll() {
        return this.repository.findAll();
    }

    public Optional<Invoice> findById(Long id) {
        return this.repository.findById(id);
    }
}
