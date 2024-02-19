package com.company.springbootjparelationship.repositorys;

import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Invoice;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long> {
    
}