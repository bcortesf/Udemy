package com.company.springbootjparelationship;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

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
import com.company.springbootjparelationship.entitys.ClientDetails;
import com.company.springbootjparelationship.entitys.Course;
import com.company.springbootjparelationship.entitys.Invoice;
import com.company.springbootjparelationship.entitys.Student;
import com.company.springbootjparelationship.repositorys.IClientDetailsRepository;
import com.company.springbootjparelationship.repositorys.IClientRepository;
import com.company.springbootjparelationship.repositorys.ICourseRepository;
import com.company.springbootjparelationship.repositorys.IInvoiceRepository;
import com.company.springbootjparelationship.repositorys.IStudentRepository;

@SpringBootApplication
public class SpringbootJpaRelationshipApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaRelationshipApplication.class, args);
	}
	// ---------------------------------------------------------------------------------
	Logger log = LoggerFactory.getLogger(getClass());

	private IClientRepository clientRepository;
	private IInvoiceRepository invoiceRepository;
	private IClientDetailsRepository clientDetailsRepository;
	private IStudentRepository studentRepository;
	private ICourseRepository courseRepository;

	SpringbootJpaRelationshipApplication (
			IClientRepository clientRepository
			,IInvoiceRepository invoiceRepository
			,IClientDetailsRepository clientDetailsRepository
			, IStudentRepository studentRepository
			, ICourseRepository courseRepository
	) {
		this.clientRepository = clientRepository;
		this.invoiceRepository = invoiceRepository;
		this.clientDetailsRepository = clientDetailsRepository;
		this.studentRepository = studentRepository;
		this.courseRepository = courseRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		//****************************************************************************************************************************/
		/****************************************UNA DIRECCION********************************************************************** */
		// manyToOne_UniDireccional_CREATE_FIND_CLIENT();
		// manyToOne_UniDireccional_CreateClient();
		// manyToOne_UniDireccional_FindClientById();
		//****************************************************************************************************************************/
		/*****************************************BI-DIRECCIONAL******************************************************************** */
		// 		¿¿¿		FALTA MANY-TO-ONE .. PENDIENTE	???


		//****************************************************************************************************************************/
		/****************************************UNA DIRECCION********************************************************************** */
		// oneToMany_UniDireccional_Create_ClientAddress();	   //->DESACOPLADO: crear-ó-mapear <tabla intermedia>
		// oneToMany_UniDireccional_Create_ClienteDireccion();    //->DESACOPLADO: crear-ó-mapear <tabla intermedia>

		// oneToMany_UniDireccional_Create_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>
		// oneToMany_UniDireccional_FindById_ClientCar();		   //->ACOPLADO   : crear-ó-mapear <campo> id_Cliente en <CARS>

		// oneToMany_UniDireccional_Delete_AddressOf_CreateClient();
		// oneToMany_UniDireccional_Delete_AddressOf_ExistingClient();
		// oneToMany_UniDireccional_Delete_AddressOf_ExistingClient_SelectQUERY();
		//****************************************************************************************************************************/
		/*****************************************BI-DIRECCIONAL******************************************************************** */
		//->Parte
			// oneToMany_Invoice_BiDireccional_CREATE();
			// oneToMany_Invoice_BiDireccional_CREATE_optimizado();
		//->Contraparte
			// manyToOne_Invoice_BiDireccional_CREATE();

		//->Cambio de "List"->"Set" cuando hay multiples relaciones en consulta -personalizada de CrudRepopsitory "IClientRepository"
		// oneToMany_Invoice_BiDireccional_FIND();

		// oneToMany_BiDireccional_Delete_InvoicesOfClient();


		//****************************************************************************************************************************/
		/****************************************UNA DIRECCION********************************************************************** */
		// oneToOne_UniDireccional_ClientToDetails_CREATE();
		// oneToOne_UniDireccional_ClientToDetails_FIND();
		//****************************************************************************************************************************/
		/*****************************************BI-DIRECCIONAL******************************************************************** */
		// oneToOne_BiDireccional_ClientToDetails_CREATE();
		// oneToOne_BiDireccional_ClientToDetails_FIND();


		//****************************************************************************************************************************/
		/****************************************UNA DIRECCION********************************************************************** */
		// ManyToMany_UniDireccional_StudentToCourse_CREATE();
		// ManyToMany_UniDireccional_StudentToCourse_FIND();
		// ManyToMany_UniDireccional_StudentToCourse_DELETE();
		ManyToMany_UniDireccional_StudentToCourse_CREATE_DELETE();
		//****************************************************************************************************************************/
		/*****************************************BI-DIRECCIONAL******************************************************************** */
		// ManyToMany_BiDireccional_ClientToXXX_CREATE();
		// ManyToMany_BiDireccional_ClientToXXX_FIND();
	}


	@Transactional
	public void manyToOne_UniDireccional_CREATE_FIND_CLIENT() {
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
	public void manyToOne_UniDireccional_CreateClient() {
		Client newClient = saveClient();
		Invoice invoice = new  Invoice("compras nuevas-1", 1000.0);
		invoice.setClient(newClient);
		Invoice invoiceDB = invoiceRepository.save(invoice);
		log.info("CLIENT-NEW: \n{}\n", invoiceDB);
	}
	@Transactional
	public void manyToOne_UniDireccional_FindClientById() {
		Optional<Client> optFoundClient = findClient(1L);

		if (optFoundClient.isPresent()) {//existing client
			Invoice invoice = new  Invoice("compras de oficina", 2000.0);
			invoice.setClient(optFoundClient.orElseThrow()); //Nueva-Factura se asigna el cliente encontrado por BD
			Invoice invoiceDB = invoiceRepository.save(invoice);
			log.info("CLIENT_FIND: \n{}\n", invoiceDB);
		}
	}


	@Transactional  //->DESACOPLADO: tabla intermedia
	private void oneToMany_UniDireccional_Create_ClientAddress() {
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
	public Client oneToMany_UniDireccional_Create_ClienteDireccion() {
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
	private void oneToMany_UniDireccional_Create_ClientCar() {
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
	private void oneToMany_UniDireccional_FindById_ClientCar() {
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
	private void oneToMany_UniDireccional_Delete_AddressOf_CreateClient() {
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
			Set<AddressDirecciones> direcciones = clientFound.getDirecciones();
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
		Client clientSAVE = oneToMany_UniDireccional_Create_ClienteDireccion();

		/*->jdk-8*/
		Set<AddressDirecciones> addresses = clientSAVE.getDirecciones().stream()
			.filter((AddressDirecciones address) -> !address.getId().equals(1L))
			.collect(Collectors.toSet());
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
	public void oneToMany_UniDireccional_Delete_AddressOf_ExistingClient() {
		Optional<Client> optClientFoundAddAddress = clientRepository.findById(2L); //Maria
		optClientFoundAddAddress.ifPresent((Client clientFoundAddAddress) -> {
			AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
			clientFoundAddAddress.setDirecciones(Set.of(
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
	public void oneToMany_UniDireccional_Delete_AddressOf_ExistingClient_SelectQUERY() {
		Optional<Client> optClientFoundAddAddress = clientRepository.findById(2L); //Maria
		optClientFoundAddAddress.ifPresent((Client clientFoundAddAddress) -> {
			AddressDirecciones address1 = new AddressDirecciones("calle 11 # 11-", 11);
			clientFoundAddAddress.setDirecciones(Set.of(
				address1,
				new AddressDirecciones("calle 22 # 22-", 22)
			));
			clientRepository.save(clientFoundAddAddress);


			/** ERROR:
	 		 * 	org.hibernate.LazyInitializationException:
	 		 * 			failed to lazily initialize a collection of role:
	 		 * 			com.company.springbootjparelationship.entitys.Client.direcciones: could not initialize proxy - no Session
			 * SOLUCION: "leerlas-en"
			 *  src\main\java\com\company\springbootjparelationship\entitys\Client.java
			 *  Client<List<Invoice> invoices;
			 */
			Optional<Client> optClientFound = clientRepository.findOneWithDirecciones(2L);
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
	//														BI-DIRECCIONAL
		//->LA-PARTE
	@Transactional
	public void oneToMany_Invoice_BiDireccional_CREATE() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("factura-1", 1111d);
		Invoice invoice2 = new Invoice("factura-2", 2222d);
		//OneToMany
		client.setInvoices(Set.of(invoice1, invoice2));
		//ManyToOne
		invoice1.setClient(client);
		invoice2.setClient(client);
		log.info("cliente-create: {}", client);
		this.clientRepository.save(client);
	}
	@Transactional
	public void oneToMany_Invoice_BiDireccional_CREATE_optimizado() {
		Client client = new Client("Fran", "Moras");

		Invoice invoice1 = new Invoice("factura-1", 1111d);
		Invoice invoice2 = new Invoice("factura-2", 2222d);

		        //OneToMany - //ManyToOne
		/*TRADICIONAL: repetir misma instancia, por cada factura */
		// client.addInvoice(invoice1);//ManyToOne
		// client.addInvoice(invoice2);//ManyToOne

		/*ENCADENADO: una misma instancia, para todas las facturas */
		client
			.addInvoice(invoice1)  //ManyToOne
			.addInvoice(invoice2); //ManyToOne

		log.info("cliente-create: {}", client);
		this.clientRepository.save(client);
	}
		//->LA-CONTRA-PARTE
	@Transactional
	public void manyToOne_Invoice_BiDireccional_CREATE() {
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


	/**
	 * ERROR:
	 * 	org.hibernate.LazyInitializationException:
	 * 			failed to lazily initialize a collection of role:
	 * 			com.company.springbootjparelationship.entitys.Client.invoices: could not initialize proxy - no Session
	 * SOLUCION: "leerlas-en"
	 *  src\main\java\com\company\springbootjparelationship\entitys\Client.java
	 *  Client<List<Invoice> invoices;
	 */
	@Transactional
	public void oneToMany_Invoice_BiDireccional_FIND() {
		//->oneClient_To_ManyInvoices
		// Optional<Client> optClient = this.findClient(2L);                             //SOLUCION(1,2) en Client<List<Invoice> invoices;>
		Optional<Client> optClient = this.clientRepository.findOneWithALL(2L); //SOLUCION(3) en Client<List<Invoice> invoices;>

		optClient.ifPresent((Client client) -> {
			Invoice invoice1 = new Invoice("factura-1", 1111d);
			Invoice invoice2 = new Invoice("factura-2", 2222d);
			//OneToMany - //ManyToOne
			client.addInvoice(invoice1).addInvoice(invoice2);

			log.info("cliente-find: {}", optClient.orElseThrow());
			Client clientUpdated = this.clientRepository.save(client);
			log.info("cliente-update: {}", clientUpdated);
		});
	}

	@Transactional
	public void oneToMany_BiDireccional_Delete_InvoicesOfClient() {
		//->Asignar facturas a cliente-1
		Optional<Client> optClient = this.clientRepository.findOneWithALL(1L);
		optClient.ifPresent((Client client) -> {
			Invoice invoice1 = new Invoice("factura-1", 1111d);//id.2
			Invoice invoice2 = new Invoice("factura-2", 2222d);//id.1
			Invoice invoice3 = new Invoice("factura-3", 3333d);//id.3
			//OneToMany - //ManyToOne
			client.addInvoice(invoice1).addInvoice(invoice2).addInvoice(invoice3);

			Client clientUpdated = this.clientRepository.save(client);
			log.info("cliente-update: {}", clientUpdated);
		});


		boolean isDeleteInvoiceOne = true;
		if (isDeleteInvoiceOne == true) {
			//->Eliminar  todas las facturas a cliente-1
			Optional<Client> optClientDEL = this.clientRepository.findOneWithALL(1L);
			optClientDEL.ifPresent((Client clientFound) -> {
				/*FORMA-1 */
				// Invoice invoicePropEqual = new Invoice("factura-2", 2222d);
				// invoicePropEqual.setId(1L);
				// Optional<Invoice> optInvoice = Optional.of(invoicePropEqual);
				/*FORMA-2: El objeto debe ser todo igual, porque el SET ES OBJ.IGUAL */
				Optional<Invoice> optInvoice = this.invoiceRepository.findById(2L);


				optInvoice.ifPresent((Invoice invoice) -> {
					//---------------------------------------
					/*ELIMINAR-SIN-OPTIMIZAR */
					/*
					//->Al Cliente remover sus Facturas //
					clientFound.getInvoices().remove(invoice);
					//->A la Factura Remover su Cliente //
					invoice.setClient(null);
					*/
					//---------------------------------------
					/*ELIMINAR-OPTIMIZADO */
					//->Al Cliente remover sus Facturas //
					clientFound.removeInvoice(invoice);
					//---------------------------------------

					//PERSISTIR
					this.clientRepository.save(clientFound);
					log.info("cliente-update: {}", clientFound);
				});
			});
		}
		if (isDeleteInvoiceOne == false) {
			//->Eliminar  todas las facturas a cliente-1
			Optional<Client> optClientDEL = this.clientRepository.findOneWithALL(1L);
			optClientDEL.ifPresent((Client clientFound) -> {
				//
				Optional<Set<Invoice>> optInvoice = this.invoiceRepository.findInvoiceByIdClient(clientFound.getId());
				optInvoice.ifPresent((Set<Invoice> invoices) -> {
					clientFound.getInvoices().removeAll(invoices);
					invoices.forEach( (Invoice invoice) -> invoice.setClient(null));

					//PERSISTIR
					this.clientRepository.save(clientFound);
				});
			});
		}
	}


	@Transactional
	public void oneToOne_UniDireccional_ClientToDetails_CREATE() {
		ClientDetails clientDetails = new ClientDetails(false, 10);
		this.clientDetailsRepository.save(clientDetails);

		Client client = new Client("Erba", "Pura");
		client.setClientDetails(clientDetails);
		Client clientDB = this.clientRepository.save(client);
		log.info("cliente-save: {}", clientDB);
	}
	@Transactional
	public void oneToOne_UniDireccional_ClientToDetails_FIND() {
		ClientDetails clientDetails = new ClientDetails(false, 10);
		this.clientDetailsRepository.save(clientDetails);
		/*ERROR: org.hibernate.LazyInitializationException: failed to lazily initialize a collection of role: com.company.springbootjparelationship.entitys.Client.direcciones: could not initialize proxy - no Session
		 *       -at org.hibernate.collection.spi.PersistentSet.toString(PersistentSet.java:300) ~[hibernate-core-6.4.1.Final.jar:6.4.1.Final]
		 *       -at com.company.springbootjparelationship.entitys.Client.toString(Client.java:225) ~[classes/:na]
		 * SOLUCION: ..\springbootjparelationship\entitys\Client
		 *       - Leer documentacion en variable  =>  "private Set<Invoice> invoices;"
		 * */
		// Optional<Client> optClient = this.clientRepository.findById(2L);              /*ERROR*/
		Optional<Client> optClient = this.clientRepository.findOneWithALL(2L); /*SOLUCION*/
		optClient.ifPresent((Client client) -> {
			client.setClientDetails(clientDetails);

			Client clientDB = this.clientRepository.save(client);
			System.out.println(MessageFormat.format("Cliente: {0}", client));
		});
	}


	@Transactional
	public void oneToOne_BiDireccional_ClientToDetails_CREATE() {
		Client client = new Client("Erba", "Pura");
		ClientDetails clientDetails = new ClientDetails(false, 10);

		// ---------------------------------------------------------------------
								/*GENERICO */
		// client.setClientDetails(clientDetails);//PADRE:Cascade.parte-operativa
		// clientDetails.setClient(client);       //HIJA :dueño-relacion(ForeingKey)

								/*OPTIMIZADO-1 */
		// client.addClientDetails(clientDetails);//PADRE:Cascade.parte-operativa

								/*OPTIMIZADO-2 */
		client.setClientDetails(clientDetails);//PADRE:Cascade.parte-operativa
		// ---------------------------------------------------------------------

		Client clientDB = this.clientRepository.save(client); //GUARDA-CASCADE
		log.info("cliente-save: {}", clientDB);
	}
	@Transactional
	public void oneToOne_BiDireccional_ClientToDetails_FIND() {
		// Optional<Client> optClient = this.clientRepository.findById(1L);//solo ID, y no trae todas las relaciones
		Optional<Client> optClient = this.clientRepository.findOneWithALL(1L);
		optClient.ifPresent((Client client) -> {
			ClientDetails clientDetails = new ClientDetails(false, 10);
			// ---------------------------------------------------
									/*OPTIMIZADO-2 */
			client.setClientDetails(clientDetails);//PADRE:Cascade
			// ---------------------------------------------------
			Client clientDB = this.clientRepository.save(client); //GUARDA-CASCADE
			System.out.println(MessageFormat.format("Cliente: {0}", clientDB));
		});
	}


	/*
	 * 1- Un <Usuario> tiene muchos <Roles>   <--y-->   Un <Rol> puede estar asignado a muchos <Usuarios>
	 * 2- Un <Producto> tiene muchas <Categorias>   <--y-->   Una <Categoria> puede estar asociado a muchos <Productos>
	 * 3-  [UDEMY]: tiene <Cursos> y <Estudiantes>
	 *     - Un <Estudiante> puede: {Comprar ó TenerAsignado} muchos <Cursos>   <--y-->   Cada <Curso> tiene a muchos <Estudiantes>
	 */
	@Transactional
	public void ManyToMany_UniDireccional_StudentToCourse_CREATE() {
		Student student1 = new Student("Bryan", "CFz");
		Student student2 = new Student("Shushi", "FM");
		Course courseSPR = new Course("Spring Boot", "Andres Guzman");
		Course courseANG = new Course("Angular", "Fernando Herrera");

		student1.setCourses(Set.of(courseSPR, courseANG));
		student2.setCourses(Set.of(courseANG));

		/*Persistencia en CASCADA.PADRE:  Guardar todos*/
		this.studentRepository.saveAll( Set.of(student1,student2) );

		//____________________________________________________________________________
		/*
		* ERROR: AL GUARDAR POR CADA ESTUDIANTE
		* org.springframework.dao.InvalidDataAccessApiUsageException: detached entity passed to persist: com.company.springbootjparelationship.entitys.Course
		* Caused by: org.hibernate.PersistentObjectException: detached entity passed to persist: com.company.springbootjparelationship.entitys.Course
		*/
		// this.studentRepository.save(student1);
		// this.studentRepository.save(student2); //ERROR: al insertar segundo estudiante
		//____________________________________________________________________________

		System.out.println(MessageFormat.format("student1: {0}, student2: {1}", student1, student2));
	}
	@Transactional
	public void ManyToMany_UniDireccional_StudentToCourse_FIND() {
		Optional<Student> optStudent1 = this.studentRepository.findByName("Minnie");
		Optional<Student> optStudent2 = this.studentRepository.findById(2L);
		optStudent1.ifPresent((Student student1) -> {
			optStudent2.ifPresent((Student student2) -> {
				Course courseDOC = this.courseRepository.findById(1L).orElseThrow();
				Course courseKUB = this.courseRepository.findById(2L).orElseThrow();

				student1.setCourses(Set.of(courseDOC, courseKUB));
				student2.setCourses(Set.of(courseKUB));

				/*Persistencia en CASCADA.PADRE:  Guardar todos*/
				this.studentRepository.saveAll( Set.of(student1,student2) );

				System.out.println(MessageFormat.format("find - student1: {0}, student2: {1}", student1, student2));
			});
		});
	}


	@Transactional
	public void ManyToMany_UniDireccional_StudentToCourse_DELETE() {

		String courseDeleteString = "Curso-Kubernates";
		this.ManyToMany_UniDireccional_StudentToCourse_FIND(); //persist(Minnie<courseSPR,courseANG>, Shushi<courseANG>)

		boolean isDeleteStep1 = true;
		if (isDeleteStep1 == true) {
			/*										***FORMA-1***							 */
			Optional<Student> optStudent1 = this.studentRepository.findOneStudentNameWithCourses("Minnie");
			optStudent1.ifPresent((Student student) -> {
				student.getCourses()
					.removeIf(
						(Course course) -> course.getName().equals("Curso-Kubernates")
					);
				this.studentRepository.save(student);
				System.out.println(MessageFormat.format("student1: {0}", student));
			});
		}
		if (isDeleteStep1 == false) {
			/*										***FORMA-2***							 */
			/*
			 * REQUIERE implementar EQUALS/HASCODE en:
			 * src\main\java\com\company\springbootjparelationship\entitys\Course.java
			 */
			Optional<Student> optStudent2 = this.studentRepository.findOneStudentNameWithCourses("Minnie");
			optStudent2.ifPresent((Student student) -> {

				Optional<Course> optCourse = this.courseRepository.findByName(courseDeleteString);
				optCourse.ifPresent((Course course) -> {

					student.getCourses().remove(course);
					this.studentRepository.save(student);
					System.out.println(MessageFormat.format("delete - student: {0}", student));
				});
			});
		}
	}

	@Transactional
	public void ManyToMany_UniDireccional_StudentToCourse_CREATE_DELETE() {
		Student student1 = new Student("Bryan", "CFz");
		Student student2 = new Student("Shushi", "FM");
		Course courseSPR = new Course("Spring Boot", "Andres Guzman");
		Course courseANG = new Course("Angular", "Fernando Herrera");

		student1.setCourses(Set.of(courseSPR, courseANG));
		student2.setCourses(Set.of(courseANG));

		/*Persistencia en CASCADA.PADRE:  Guardar todos*/
		this.studentRepository.saveAll( Set.of(student1,student2) );


		//ELIMINAR
		String courseDeleteString = "Spring Boot";
		Optional<Student> optStudent2 = this.studentRepository.findOneStudentIdWithCourses(4L);
		optStudent2.ifPresent((Student student) -> {

			Optional<Course> optCourse = this.courseRepository.findByName(courseDeleteString);
			optCourse.ifPresent((Course course) -> {

				student.getCourses().remove(course);
				this.studentRepository.save(student);
				System.out.println(MessageFormat.format("delete - student: {0}", student));
			});
		});
	}










	// @Transactional
	// public void ManyToMany_BiDireccional_ClientToXXX_CREATE() {
		//
	// }


	//--------------------------------------------------------------------------------------------------------------------
	//--------------------------------------------------------------------------------------------------------------------
	// String result = MessageFormat.format("String {0} in {1} with some {1} examples.", firstVariable, secondVariable);
	// System.out.println(MessageFormat.format("Cliente: {0}", client));
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
