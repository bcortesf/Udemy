package com.company.springbootjparelationship;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.company.springbootjparelationship.entitys.Address;
import com.company.springbootjparelationship.entitys.AddressDirecciones;
import com.company.springbootjparelationship.entitys.Car;
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
		/*UNA DIRECCION */
		// manyToOne_CREATE_FIND_CLIENT();
		// manyToOne_CreateClient();
		// manyToOne_FindClientById();


		/*UNA DIRECCION */
		// oneToMany_Create_ClientAddress();	   //->DESACOPLADO: crear-ó-mapear <tabla intermedia>
		// oneToMany_Create_ClienteDireccion();    //->DESACOPLADO: crear-ó-mapear <tabla intermedia>

		// oneToMany_Create_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>
		// oneToMany_FindById_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>

		// oneToMany_Delete_AddressOf_CreateClient();
		// oneToMany_Delete_AddressOf_ExistingClient();
		// oneToMany_Delete_AddressOf_ExistingClient_SelectQUERY();


					/*BI-DIRECCIONAL */
		// oneToMany_Invoice_bidireccional_CREATE();
		// oneToMany_Invoice_bidireccional_FIND();

		//->Contraparte
		manyToOne_Invoice_bidireccional_CREATE();
	}


	@Transactional
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
	@Transactional
	public void manyToOne_CreateClient() {
		Client newClient = saveClient();
		Invoice invoice = new  Invoice("compras nuevas-1", 1000.0);
		invoice.setClient(newClient);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		log.info("CLIENT-NEW: \n{}\n", invoiceDB);
	}
	@Transactional
	public void manyToOne_FindClientById() {
		Optional<Client> optFoundClient = findClient(1L);

		if (optFoundClient.isPresent()) {//existing client
			Invoice invoice = new  Invoice("compras de oficina", 2000.0);
			invoice.setClient(optFoundClient.orElseThrow()); //Nueva-Factura se asigna el cliente encontrado por BD
			Invoice invoiceDB = invoiceRepository.save(invoice);
			log.info("CLIENT_FIND: \n{}\n", invoiceDB);
		}
	}


	@Transactional  //->DESACOPLADO: tabla intermedia
	private void oneToMany_Create_ClientAddress() {
		Client client = new Client("Frank1", "Moras1");
		//->FORMA-1
		Address address1 = new Address("calle 11 # 11-", 11);
		Address address2 = new Address("calle 22 # 22-", 22);
		client.getAddresses().add(address1);
		client.getAddresses().add(address2);

		Client clientBD = clientRepository.save(client);
		log.info("oneToMAny(Client-Address) newClient: \n{}\n", clientBD);
	}
	@Transactional  //->DESACOPLADO: tabla intermedia
	public Client oneToMany_Create_ClienteDireccion() {
		Client client = new Client("Frank2", "Moras2");
		//->FORMA-1
		AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
		AddressDirecciones address2 = new AddressDirecciones("calle 22 # 22-", 22);
		client.getDirecciones().add(address1);
		client.getDirecciones().add(address2);

		Client clientBD = clientRepository.save(client);
		log.info("oneToMAny(Client-AddressDirecciones) newClient: \n{}\n", clientBD);
		return clientBD;
	}

	@Transactional  //->ACOPLADO   : directo campo id_Cliente en <CARS>
	private void oneToMany_Create_ClientCar() {
		Client client = new Client("Miguel", "Romero");
		//->FORMA-2
		client.setCars(Arrays.asList(
			new Car("Nissan March 2024"),
			new Car("Kia Picanto 2024")
		));

		Client clientBD = clientRepository.save(client);
		log.info("oneToMAny(Client-Car) newClient: \n{}\n", clientBD);
	}

	@Transactional  //->ACOPLADO   : directo campo id_Cliente en <CARS>
	private void oneToMany_FindById_ClientCar() {
		findClient(2L).ifPresent((Client foundClient) -> {
			//->FORMA-2
			foundClient.setCars(Arrays.asList(
				new Car("Nissan March 2024"),
				new Car("Kia Picanto 2024")
			));
			Client clientBD = clientRepository.save(foundClient);
			log.info("oneToMAny(Client-Car) foundClient: \n{}\n", clientBD);
		});
	}


	/*COMPARACIONES, BUSQUEDAD Y ELIMINACIONES :"hashCode / equals"
	    - public int hashCode()
	    - public boolean equals(Object obj)
	 *IMPLEMENTADO: src\main\java\com\company\springbootjparelationship\entitys\AddressDirecciones.java
	*/
	@Transactional
	private void oneToMany_Delete_AddressOf_CreateClient() {
		Client client = new Client("Frank2", "Moras2");
		AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
		AddressDirecciones address2 = new AddressDirecciones("calle 22 # 22-", 22);
		client.getDirecciones().add(address1);
		client.getDirecciones().add(address2);
		clientRepository.save(client);

		/*->PROBLEMA-LAZY: por-Listas-Perezosas
		 * org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role:
		 * 		com.company.springbootjparelationship.entitys.Client.direcciones: could not initialize proxy - no Session
		 *
		 * ->SOLUCION-TEMPORAL-LAZY (application.properties)
		 * spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
		 */
		Optional<Client> optClientFound = clientRepository.findById(3L); /*ERROR-LAZY */
		optClientFound.ifPresent((Client clientFound) -> { //solo info de Cliente. LAS-LISTAS-LAZY ~ "LISTAS=NULL"
			List<AddressDirecciones> direcciones = clientFound.getDirecciones();
				/*ELIMINACION POR INDEX */
				// direcciones.remove(0)

				/*PROBLEMA ELIMINACION POR OBJETO: en clase<AddressDirecciones> implementar un "hashCode/equals"
				 * 	-al agregar  "address1" a cliente, jpa asigna en memoria una direccion"address1.aaa1"
				 *  -al eliminar "address1" a cliente, en BD.direccion"address1-aaa1" es diferente ~ a LOCAL.direccion"address1"
				 *
				 * SOLUCION ELIMINACION POR OBJETO: en clase<AddressDirecciones> implementar un "hashCode/equals"
				*/
				direcciones.remove(address1);
			//ELIMINA-TABLAS-EN-CASCADA(clientes_a_direcciones, addressesdirecciones)
			Client clienteDireccionEliminada = clientRepository.save(clientFound);
			log.info("oneToMAny(Client-Car) deleteAddress-Client-BD: \n{}\n", clienteDireccionEliminada);
		});

		/* .......................................................................... */
		/*FUNCIONA-PORQUE-ESTA-EN-LA-MISMA-TRANSACCIÓN */
		// oneToMany_Delete_AddressOfClient_sameTransaction();
	}
	@Transactional
	private void oneToMany_Delete_AddressOfClient_sameTransaction() {
		/* .......................................................................... */
		/*FUNCIONA-PORQUE-ESTA-EN-LA-MISMA-TRANSACCIÓN */
		Client clientSAVE = oneToMany_Create_ClienteDireccion();

		/*->jdk-8*/
		List<AddressDirecciones> addresses = clientSAVE.getDirecciones().stream()
			.filter((AddressDirecciones address) -> !address.getId().equals(1L))
			.toList();
		clientSAVE.setDirecciones(addresses);
		Client clientAddressDelete = clientRepository.save(clientSAVE);
		log.info("oneToMAny(Client-Car) deleteAddress-Client: \n{}\n", clientAddressDelete);

		/*->jdk-7*/
		/*clientSAVE.getDirecciones().remove(0); //->Address address1 = new Address("calle 11 # 11-", 11);
		Client clientAddressDelete = clientRepository.save(clientSAVE);
		log.info("oneToMAny(Client-Car) deleteAddress-Client: \n{}\n", clientAddressDelete);
		*/
	}

	/*
	 * ###CARGA PARA LISTAS PEREZOSAS CONFIGURADAS CON:  "fetch = FetchType.LAZY"
	 * spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
	 */
	@Transactional
	public void oneToMany_Delete_AddressOf_ExistingClient() {
		Optional<Client> optClientFoundAddAddress = clientRepository.findById(2L); //Maria
		optClientFoundAddAddress.ifPresent((Client clientFoundAddAddress) -> {
			AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
			clientFoundAddAddress.setDirecciones(Arrays.asList(
				address1,
				new AddressDirecciones("calle 22 # 22-", 22)
			));
			clientRepository.save(clientFoundAddAddress);

			//....
			Optional<Client> optClientFound = findClient(2L);
			optClientFound.ifPresent((Client foundClient) -> {
				log.info("oneToMAny(Client-AddressesDirecciones) clientFound: \n{}\n", foundClient);
				foundClient.getDirecciones().remove(address1);
				Client clientFoundDeleteAddress = clientRepository.save(foundClient);
				log.info("oneToMAny(Client-AddressesDirecciones) clientFoundDeleteAddress: \n{}\n", clientFoundDeleteAddress);
			});
		});
	}


	/*Eliminar objetos dependientes con relacion existente */
	@Transactional
	public void oneToMany_Delete_AddressOf_ExistingClient_SelectQUERY() {
		Optional<Client> optClientFoundAddAddress = clientRepository.findById(2L); //Maria
		optClientFoundAddAddress.ifPresent((Client clientFoundAddAddress) -> {
			AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
			clientFoundAddAddress.setDirecciones(Arrays.asList(
				address1,
				new AddressDirecciones("calle 22 # 22-", 22)
			));
			clientRepository.save(clientFoundAddAddress);

			//....
			Optional<Client> optClientFound = clientRepository.findOne(2L);
			optClientFound.ifPresent((Client foundClient) -> {
				//Cliente con 2 direcciones
				log.info("oneToMAny(Client-AddressesDirecciones) query - clientFound: \n{}\n", foundClient);

				//Cliente con 1 direccion
				foundClient.getDirecciones().remove(address1);
				Client clientFoundDeleteAddress = clientRepository.save(foundClient);
				log.info("oneToMAny(Client-AddressesDirecciones) query - clientFoundDeleteAddress: \n{}\n", clientFoundDeleteAddress);
			});
		});
	}

	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	//														BIDIRECCIONAL
	@Transactional
	public void oneToMany_Invoice_bidireccional_CREATE() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("factura-1", 1111d);
		Invoice invoice2 = new Invoice("factura-2", 2222d);
		//OneToMany
		client.setInvoices(Arrays.asList(invoice1, invoice2));
		//ManyToOne
		invoice1.setClient(client);
		invoice2.setClient(client);
		log.info("cliente-create: {}", client);
		this.clientRepository.save(client);
	}
	@Transactional
	public void oneToMany_Invoice_bidireccional_FIND() {
		//->oneClient_To_ManyInvoices
		Optional<Client> optClient = this.findClient(2L);
		optClient.ifPresent((Client client) -> {
			Invoice invoice1 = new Invoice("factura-1", 1111d);
			Invoice invoice2 = new Invoice("factura-2", 2222d);
			//OneToMany
			client.setInvoices(Arrays.asList(invoice1, invoice2));
			//ManyToOne
			invoice1.setClient(client);
			invoice2.setClient(client);

			log.info("cliente-find: {}", optClient.orElseThrow());
			this.clientRepository.save(client);
		});
	}
	//LA-CONTRA-PARTE
	@Transactional
	public void manyToOne_Invoice_bidireccional_CREATE() {
		//->manyInvoices_To_oneClient

		Invoice invoice1 = new Invoice("factura-1b", 1111d);
		Invoice invoice2 = new Invoice("factura-2b", 2222d);
		List<Invoice> invoices = Arrays.asList(invoice1,invoice2);

		Client client = new Client("Fran", "Moras");
		this.clientRepository.save(client);

		//ManyToOne
		int index = 0;
		for (Invoice invoice : invoices) {
			invoice.setClient(client);
			Invoice invoiceDB = this.invoiceRepository.save(invoice);
			log.info("invoice-{}-create: {}", index++, invoiceDB);
		}

	}


	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	private Client saveClient() {
		Client client = new Client("John", "Doe");
		return clientRepository.save(client);
	}
	private Optional<Client> findClient(long idClient) {
		return clientRepository.findById(idClient);
	}


}
