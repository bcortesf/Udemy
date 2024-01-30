package com.company.springbootdifactura.repositorys;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.springbootdifactura.models.Client;
import com.company.springbootdifactura.models.Invoice;
import com.company.springbootdifactura.models.InvoiceItem;
import com.company.springbootdifactura.models.Product;

@Repository
public class InvoiceRepositoryImpl implements IInvoiceRepository {
    Logger log = LoggerFactory.getLogger(getClass());

    private Invoice invoice;

    public InvoiceRepositoryImpl() {
        invoice = setInvoice();
        setPriceInvoice();
    }

    private Invoice setInvoice() {
        invoice = new Invoice(
            1L,
            "Alkosto",
            new Client(1L, "Shushi"),
            Arrays.asList(
                new InvoiceItem(1L, 3, 1500.0f, 0.0f
                    , new Product(1L, "papas fritas - margarita", LocalDate.parse("2024-01-29")) ),
                new InvoiceItem(2L, 2, 1000.0f, 0.0f
                    , new Product(2L, "carne hamburguesa - angus", LocalDate.parse("2024-01-30")) )
            ),
            0.0f
        );

        this.log.info("INVOICE-INIT:\n {}\n\n", invoice);
        return invoice;
    }
    public void setPriceInvoice() {
        invoice.getItems().stream()
        .forEach((InvoiceItem invoiceItem) -> {
            invoiceItem.setSum( invoiceItem.getPrice() * invoiceItem.getQuantity() );
            invoice.setTotal( invoice.getTotal() + invoiceItem.getSum() );
        });
        this.log.info("FINAL-INVOICE-CALCULATED:\n {}\n\n", invoice);
    }

    @Override
    public List<Invoice> findAll() {
        // return Collections.singletonList(invoice);
        // List<Invoice> list = new ArrayList<>();    list.add(invoice);    return list;
        return Arrays.asList(invoice);
    }

}
