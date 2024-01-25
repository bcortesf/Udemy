package com.company.springboot3di.repositories;

import java.util.List;
import java.util.Optional;

import com.company.springboot3di.models.Invoice;

public interface IInvoice {
    public List<Invoice> findAll();
    public Optional<Invoice> findById(Long id);
}
