package com.company.springbootdifactura.repositorys;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.springbootdifactura.models.Client;
import com.company.springbootdifactura.models.Invoice;
import com.company.springbootdifactura.models.InvoiceItem;
import com.company.springbootdifactura.models.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Repository
public class InvoiceRepositoryImpl implements IInvoiceRepository {
    Logger log = LoggerFactory.getLogger(getClass());


    private Invoice invoice;          //->setInvoice()
    private Invoice invoiceCOMPONENT; //->@Autowired

    public InvoiceRepositoryImpl(Invoice invoiceCOMPONENT) {
        invoice = setInvoice();
        setPriceInvoice(invoice);
        ////////////////////////////////////////
        this.invoiceCOMPONENT = invoiceCOMPONENT; //->@Autowired
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
    private void setPriceInvoice(Invoice invoiceREFERENCE) { //invoice-by-reference
        invoiceREFERENCE.getItems().stream()
        .forEach((InvoiceItem item) -> {
            item.setSum( item.getPrice() * item.getQuantity() );
            invoiceREFERENCE.setTotal( invoiceREFERENCE.getTotal() + item.getSum() );
        });
        this.log.info("FINAL-INVOICE-CALCULATED:\n {}\n\n", invoice);
    }

    @Override
    public List<Invoice> findAll() {
        // return Collections.singletonList(invoice);
        // List<Invoice> list = new ArrayList<>();    list.add(invoice);    return list;
        return Arrays.asList(invoice);
    }


    /*************************************************************************** */
    /******************************PRUEBAS************************************** */
    /*************************************************************************** */
    @Override
    public String buildInvoiceStringCOMPONENT() {
        this.setInvoicePropertys();
        this.log.info("TEST.TO-STRING():\n {}\n\n", invoiceCOMPONENT);
        return convertStringToJSON();
    }
    @Override
    public Invoice buildInvoiceCOMPONENT() {
        this.setInvoicePropertys();
        this.log.info("TEST.TO-OBJ():\n {}\n\n", invoiceCOMPONENT);
        return invoiceCOMPONENT;
    }



    private void setInvoicePropertys() {
        this.invoiceCOMPONENT.setId(1L);
        this.invoiceCOMPONENT.setTotal(1f);
        this.setPriceInvoice(this.invoiceCOMPONENT);
    }
    private String convertStringToJSON() {
        /* https://mkyong.com/java/jackson-java-8-date-time-type-java-time-localdate-not-supported-by-default/
         * // Convert Java object to JSON:
         */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            String jsonDeveloperServerConsole = objectMapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(invoiceCOMPONENT);
            this.log.info("TEST.TO-JSON:\n {}\n\n", jsonDeveloperServerConsole);
            return objectMapper.writeValueAsString(invoiceCOMPONENT);
        } catch (JsonProcessingException e) {
            this.log.info("ERROR-JSON:\n {}\n\n", e.getMessage());
            return e.getMessage();
        }
    }

}
