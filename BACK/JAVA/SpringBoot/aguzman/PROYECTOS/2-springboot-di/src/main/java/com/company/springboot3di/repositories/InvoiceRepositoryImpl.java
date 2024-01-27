package com.company.springboot3di.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.company.springboot3di.data.InvoiceData;
import com.company.springboot3di.models.Invoice;
import com.company.springboot3di.models.Client;
import com.company.springboot3di.models.Product;

@Repository
public class InvoiceRepositoryImpl implements IInvoiceRepository {
    Logger log = LoggerFactory.getLogger(getClass());

    //->Con Inyección De Dependencia (IoC)
    private InvoiceData dataInvComponent;
    private ClientRepositoryImpl clientRepository;
    private ProductRepositoryImpl productRepository;


    public InvoiceRepositoryImpl(InvoiceData dataInvComponent,
            ClientRepositoryImpl clientRepository
            ,ProductRepositoryImpl productRepository
    ) {
        this.dataInvComponent = dataInvComponent;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }


    public void buildInvoiceData() {
        this.dataInvComponent.getDataList().clear();  //->Por que es singleton  ... this.dataBi.setDataList(new ArrayList<>())
        InvoiceData dataInvoice = new InvoiceData();


        Invoice invoice1 = new Invoice();
        List<Product> productList = new ArrayList<>(invoice1.getProducts());          //->new getInstance []

        //->nuevas-instancias-sin-elementos
        log.info("  PRODUCTOS-inicial: {}\n", productList);

        Optional<Client> optClient1 = this.clientRepository.findById(1L);
            Product product1 = this.productRepository.findById(1L).orElse(new Product());
            Product product2 = this.productRepository.findById(2L).orElse(new Product());
            productList.add(product1); productList.add(product2);
        invoice1.setId(1L);
        invoice1.setClient(optClient1.orElse(new Client()) );
            invoice1.setProducts(productList);
        dataInvoice.getDataList().add(invoice1); //->Agrego data FACTURA

        //
        log.info("MI_LOG #1 \n"
            + "THIS.BILL-1:\n {}"
            + "\n\nTHIS.BILL-DATA-LIST-1:\n {}"
            , invoice1, dataInvoice.getDataList()
        );

        log.info("\n.......................................................................................\n");
        Invoice invoice2 = new Invoice();
        List<Product> productList2 = new ArrayList<>(invoice2.getProducts());          //->new getInstance []

        Optional<Client> optClient2 = this.clientRepository.findById(2L);
            Product product3 = this.productRepository.findById(3L).orElse(new Product());
            productList2.add(product3);
        invoice2 = new Invoice();
        invoice2.setId(2L);
        invoice2.setClient(optClient2.orElse(new Client()));
            invoice2.setProducts(productList2);
        dataInvoice.getDataList().add(invoice2); //->Agrego data FACTURA

        log.info("MI_LOG #2 \n"
            + "THIS.BILL-2:\n {}"
            + "\n\nTHIS.BILL-DATA-LIST-2:\n {}"
            , invoice2, dataInvoice.getDataList()
        );

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        log.info("\n.......................................................................................\n");
        /*VISTA-TEMPORAL-PARA-LOGS */
        /*InvoiceData data = new InvoiceData()
        data.getDataList().add(invoice1); data.getDataList().add(invoice2)
        log.info("MI_LOG #3 \n"
            + "data:\n {}"
            , data
        )*/

        /*SETEANDO-BILL-DATA */
        this.dataInvComponent.getDataList().add(invoice1);
        this.dataInvComponent.getDataList().add(invoice2);
        log.info("MI_LOG #3 \n"
            + "\n\nTHIS.BILL-DATA-LIST:\n {}"
            , this.dataInvComponent.getDataList()
        );
    }


    @Override
    public List<Invoice> findAll() {
        this.buildInvoiceData();
        return this.dataInvComponent.getDataList();
    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return findAll().stream()
            .filter((Invoice b) -> b.getId().equals(id))
            .findFirst();
    }

}