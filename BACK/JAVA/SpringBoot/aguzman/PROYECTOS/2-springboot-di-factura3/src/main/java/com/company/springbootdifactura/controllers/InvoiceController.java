package com.company.springbootdifactura.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.springbootdifactura.models.Invoice;
import com.company.springbootdifactura.repositorys.InvoiceRepositoryImpl;
import com.company.springbootdifactura.services.IInvoiceService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping(value = "invoice")
public class InvoiceController {
    Logger log = LoggerFactory.getLogger(getClass());

    private Map<String, Object> json;
    private IInvoiceService service;


    public InvoiceController(IInvoiceService service
    ) {
        this.json = new HashMap<>();
        this.service = service;
    }

    @GetMapping(value = "list")
    public Map<String, Object> getFindAll() {
        json.put("invoice", this.service.findAll());
        return json;
    }


/*************************************************************************** */
    /******************************PRUEBAS************************************** */
    /*************************************************************************** */

    @GetMapping(path = "/test-str")
    public String buildInvoiceStringCOMPONENT(){
        String  invoiceString = this.service.buildInvoiceStringCOMPONENT();

        this.log.info("TEST.CTRLL.JSON:\n {}\n\n", invoiceString);

        return invoiceString;
        // return ":)"
    }
    @GetMapping(path = "/test-obj")
    public Invoice buildInvoiceCOMPONENT(){
        Invoice  invoice = this.service.buildInvoiceCOMPONENT();

        this.log.info("TEST.CTRLL.JSON:\n {}\n\n", invoice);

        return invoice;
        // return ":)"
    }

}
