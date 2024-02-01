package com.company.springbootdifactura.configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.company.springbootdifactura.models.InvoiceItem;
import com.company.springbootdifactura.models.Product;

@PropertySource(value = "classpath:invoice.properties", encoding = "UTF-8")
@Configuration
public class InvoiceConfiguration {

    /*
     * .\src\main\java\com\company\springbootdifactura\models\Invoice.java
     * <Invoice>.List<InvoiceItem> items
     */
    @Bean
    List<InvoiceItem> invoiceGetItems() {
        Product product1 =
            new Product(1L, "papas fritas - margarita", LocalDate.parse("2024-01-29"));
        Product product2 =
            new Product(2L, "carne hamburguesa - angus", LocalDate.parse("2024-01-30"));

        return Arrays.asList(
            new InvoiceItem(1L, 3, 1500.0f, 0.0f, product1),
            new InvoiceItem(2L, 2, 3000.0f, 0.0f, product2)
        );
    }

    // @Bean
    // List<InvoiceItem> invoiceGetItems2() {
    //     return new ArrayList<>();
    // }
}
