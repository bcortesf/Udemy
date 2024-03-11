package com.company.springbootjparelationship.repositorys;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Invoice;

public interface IInvoiceRepository extends CrudRepository<Invoice, Long> {
    @Query(value = "select i from Invoice i join Client c on i.client.id=c.id where c.id=?1")
    Optional<Set<Invoice>> findInvoiceByIdClient(Long idClient);
}