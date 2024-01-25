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
public class InvoiceRepository implements IInvoice {
    Logger log = LoggerFactory.getLogger(getClass());

    private InvoiceData dataBi;
    private ClientRepository clientRepository;
    private ProductRepository productRepository;

    public InvoiceRepository(InvoiceData dataBi,
            ClientRepository clientRepository
            ,ProductRepository productRepository
    ) {
        this.dataBi = dataBi;
        this.clientRepository = clientRepository;
        this.productRepository = productRepository;
    }


    public void buildInvoiceData() {
        this.dataBi.getDataList().clear();  //-> this.dataBi.setDataList(new ArrayList<>())

        Invoice bill1, bill2;
        InvoiceData dataBill1, dataBill2;


        bill1 = new Invoice();
        dataBill1 = new InvoiceData();
        List<Product> productList = new ArrayList<>(bill1.getProducts());    //instancia
        List<Invoice> billDataList   = new ArrayList<>(dataBill1.getDataList());//instancia
        log.info("  PRODUCTOS-inicial: {}, FACTURAS-inicial: {}\n", productList, billDataList); //nuevas-instancias-sin-elementos

        Optional<Client> optClient1 = this.clientRepository.findById(1L);
            Optional<Product> optProduct1 = this.productRepository.findById(1L);
            Optional<Product> optProduct2 = this.productRepository.findById(2L);
            productList.add(optProduct1.get()); productList.add(optProduct2.get());
        bill1.setId(1L);
        bill1.setClient(optClient1.get());
            bill1.setProducts(productList);
        dataBill1.getDataList().add(bill1); //->Agrego data FACTURA

        //
        log.info("MI_LOG #1 \n"
            + "THIS.BILL-1:\n {}"
            + "\n\nlocal__bill-data-list:\n {}"
            + "\n\nTHIS.BILL-DATA-LIST:\n {}"
            , bill1, billDataList, dataBill1.getDataList()
        );


        log.info("\n.......................................................................................\n");


        bill2 = new Invoice();
        dataBill2 = new InvoiceData();
        List<Product> productList2 = new ArrayList<>(bill2.getProducts());
        List<Invoice> billDataList2   = new ArrayList<>(dataBill2.getDataList());


        Optional<Client> optClient2 = this.clientRepository.findById(2L);
            Optional<Product> optProduct3 = this.productRepository.findById(3L);
            productList2.add(optProduct3.get());
        bill2 = new Invoice();
        bill2.setId(5L);
        bill2.setClient(optClient2.get());
            bill2.setProducts(productList2);
        dataBill1.getDataList().add(bill2); //->Agrego data FACTURA

        log.info("MI_LOG #2 \n"
            + "THIS.BILL-1:\n {}"
            + "\n\nlocal__bill-data-list:\n {}"
            + "\n\nTHIS.BILL-DATA-LIST:\n {}"
            , bill2, billDataList2, dataBill2.getDataList()
        );

        
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////
        log.info("\n.......................................................................................\n");
        /*VISTA-TEMPORAL-PARA-LOGS */
        // InvoiceData data = new InvoiceData();
        // data.getDataList().add(bill1); data.getDataList().add(bill2);
        // log.info("MI_LOG #3 \n"
        //     + "data:\n {}"
        //     , data
        // );

        /*SETEANDO-BILL-DATA */
        this.dataBi.getDataList().add(bill1);
        this.dataBi.getDataList().add(bill2);
        log.info("MI_LOG #3 \n"
            + "\n\nTHIS.BILL-DATA-LIST:\n {}"
            , this.dataBi.getDataList()
        );
    }


    @Override
    public List<Invoice> findAll() {
        this.buildInvoiceData();
        return this.dataBi.getDataList();

    }

    @Override
    public Optional<Invoice> findById(Long id) {
        return findAll().stream()
            .filter((Invoice b) -> b.getId().equals(id))
            .findFirst();
    }

}