package com.company.springbootjparelationship;

import java.util.Arrays;
import java.util.Collections;
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
		// manyToOne_CREATE_FIND_CLIENT();
		// manyToOne_CreateClient();
		// manyToOne_FindClientById();


		/*UNA DIRECCION */
		// oneToMany_Create_ClientAddress();	   //->DESACOPLADO: crear-ó-mapear <tabla intermedia>
		// oneToMany_Create_ClienteDireccion();    //->DESACOPLADO: crear-ó-mapear <tabla intermedia>

		// oneToMany_Create_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>
		// oneToMany_FindById_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>

		oneToMany_Delete_AddressOf_CreateClient();
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

				/*ELIMINACION POR OBJETO: en clase<AddressDirecciones> implementar un "hashCode/equals"
				 * MOTIVO:
				 * 	-al agregar  "address1" a cliente, jpa asigna en memoria una direccion"address1.aaa1"
				 *  -al eliminar "address1" a cliente, en BD.direccion"address1-aaa1" es diferente ~ a LOCAL.direccion"address1"
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


	//----------------------------------------------------------
	private Client saveClient() {
		Client client = new Client("John", "Doe");
		return clientRepository.save(client);
	}
	private Optional<Client> findClient(long idClient) {
		return clientRepository.findById(idClient);
	}


}
