package com.company.springbootjparelationship.repositorys;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.company.springbootjparelationship.entitys.Client;

public interface IClientRepository extends CrudRepository<Client, Long> {
    /** https://www.arquitecturajava.com/jpa-join-fetch-uso/
     * .
     */

     //->trae "Clientes" que; (SI-TENGAN)."Direcciones"
    @Query(value = "select c from Client c join fetch c.direcciones where c.id=?1")
    Optional<Client> findOneWithDirecciones(Long idCliente);


    //->trae "Clientes" que; (SI-TENGAN)."Facturas"
    @Query(value = "select c from Client c join fetch c.invoices where c.id=?1")
    Optional<Client> findOneWithInvoices(Long idCliente);
    //->trae "Clientes" que; (TIENEN_Y_NO-TIENEN)."Facturas"
    @Query(value = "select c from Client c left join fetch c.invoices where c.id=?1")
    Optional<Client> findOneWithLeftInvoices(Long idCliente);
    /**
     * SI TENEMOS MAS DE UNA RELACION CON OTRAS TABLAS, HACER UN TODO EN UNO
     */
    //->trae "Clientes" que;   (TIENEN_Y_NO-TIENEN)."Facturas"  y  (TIENEN_Y_NO-TIENEN)."Direcciones"
    // @Query(value = "select c from Client c left join fetch c.invoices left join fetch c.direcciones where c.id=?1")
    @Query(value = "select c from Client c left join fetch c.invoices left join fetch c.direcciones left join fetch c.clientDetails where c.id=?1")
    Optional<Client> findOneWithALL(Long idCliente);
}
