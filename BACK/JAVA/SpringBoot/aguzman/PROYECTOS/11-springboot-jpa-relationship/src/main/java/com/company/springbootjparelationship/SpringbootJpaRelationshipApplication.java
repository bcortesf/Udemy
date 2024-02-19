package com.company.springbootjparelationship;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.company.springbootjparelationship.entitys.Client;
import com.company.springbootjparelationship.entitys.Invoice;
import com.company.springbootjparelationship.repositorys.IClientRepository;
import com.company.springbootjparelationship.repositorys.IInvoiceRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}
	// ---------------------------------------------------------------------------------
	Logger log = LoggerFactory.getLogger(getClass());

	private IClientRepository clientRepository;
	private IInvoiceRepository invoiceRepository;

	SpringbootJpaRelationshipApplication (
			IClientRepository clientRepository
			,IInvoiceRepository invoiceRepository
	) {
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		// manyToOne_CREATE_FIND_CLIENT();
		// manyToOne_CreateClient();
		manyToOne_FindClientById();
		// manyToOne();
	}

	public void manyToOne_CREATE_FIND_CLIENT() {
		Invoice invoiceDB = null;
		Optional<Client> optFoundClient = findClient(3L);

		if (findClient(3L).isPresent()) {//existing client
			Invoice invoice = new  Invoice("compras de oficina", 2000.0);
			invoice.setClient(optFoundClient.orElseThrow());
			invoiceDB = invoiceRepository.save(invoice);
		}
		if (findClient(3L).isEmpty()) {//new client
			Client newClient = saveClient();
			Invoice invoice = new  Invoice("compras nuevas-1", 1000.0);
			invoice.setClient(newClient);
			invoiceDB = invoiceRepository.save(invoice);
		}
		log.info("CLIENT-CREATE_FIND: \n{}\n", invoiceDB);
	}
	public void manyToOne_CreateClient() {
		Client newClient = saveClient();
		Invoice invoice = new  Invoice("compras nuevas-1", 1000.0);
		invoice.setClient(newClient);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		log.info("CLIENT-NEW: \n{}\n", invoiceDB);
	}
	public void manyToOne_FindClientById() {
		Optional<Client> optFoundClient = findClient(1L);

		if (optFoundClient.isPresent()) {//existing client
			Invoice invoice = new  Invoice("compras de oficina", 2000.0);
			invoice.setClient(optFoundClient.orElseThrow()); //Nueva-Factura se asigna el cliente encontrado por BD
			Invoice invoiceDB = invoiceRepository.save(invoice);
			log.info("CLIENT_FIND: \n{}\n", invoiceDB);
		}
	}


	private Client saveClient() {
		Client client = new Client("John", "Doe");
		return clientRepository.save(client);
	}
	private Optional<Client> findClient(long idClient) {
		return clientRepository.findById(idClient);
	}


}
