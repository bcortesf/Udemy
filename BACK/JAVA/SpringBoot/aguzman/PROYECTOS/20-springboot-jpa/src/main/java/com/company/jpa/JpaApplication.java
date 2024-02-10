package com.company.jpa;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.company.jpa.entitys.Person;
import com.company.jpa.entitys.dto.PersonDto;
import com.company.jpa.repositorys.IPersonRepository;


/**
 * CommandLineRunner
 * - Para trabajar en consola
 */
@SpringBootApplication
public class JpaApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}
	/////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////
	private Logger log = LoggerFactory.getLogger(getClass());
	private IPersonRepository repository;

	public JpaApplication(IPersonRepository repository) {
		this.repository = repository;
	}


	@Override
	public void run(String... args) throws Exception {
		/* *********** */
		/*CRUD: PERSON */
		// create();
		// update();
		// delete();
		// find();
		/* *********** */

		// personalizedQueries();
		personalizedQueries2();
	}


	@Transactional(readOnly = true)
	public void personalizedQueries2(){
		System.out.println("============POR-OBJETO-PERSONA-Y-LENGUAJE_PROGRAMACION============");
		List<Object[]> listMixt = repository.findAllMixPersonsDataList();
		listMixt.forEach((Object[] rowPers) -> {
			log.info("MIX-PARAMS \nfila:{}, \nprogrammingLanguaje:{}, \nPersonOBJ:{}", rowPers, rowPers[1], rowPers[0]);
		});

		System.out.println("============POR-CLASS-PERSON============");
		List<Person> personsAllFields = repository.findAllEntityPerson();
		List<Person> personAnyFields  = repository.findAllEntityPersonByFiedls();
		List<PersonDto> personDTO  = repository.findAllClassPersonDTO();

		log.info("personsAllFields:{}\n", personsAllFields);
		log.info("personAnyFields:{}\n", personAnyFields);
		log.info("personDTO:{}\n", personDTO);



		// PersonDto dataDTO = repository.getPersonDtoDataFullById(idPerson);
		// log.info("ID:{}, full-data es:{}, id={}", idPerson, dataObject,
		// dataObject );
	}


	@Transactional(readOnly = true)
	public void personalizedQueries() {
		Long idPerson = 1L;
		System.out.println("============POR-NOMBRE============");
		String personName = repository.getNameById(idPerson);
		log.info("ID:{}, Su nombre es:{}", idPerson, personName);
		System.out.println("============POR-ID============");
		Long personId = repository.getIdById(idPerson);
		log.info("ID:{}, Su id es:{}", idPerson, personId);
		System.out.println("============POR-NOMBRE-COMPLETO-CONCAT============");
		String personFullName = repository.getFullNameById(idPerson);
		log.info("ID:{}, Su nombre-completo es:{}", idPerson, personFullName);
		System.out.println("============POR-OBJECT-FULL============");
		Object[] dataObject = (Object[]) repository.obtenerPersonDataFullObjById(idPerson);
		Optional<Object> dataOptional = repository.obtenerPersonDataFullOptById(idPerson);
		log.info("DATA-OBJECT  -  ID:{}, full-data es:{}, id={}, nombre={}, apellido={}, lenguaje={}", idPerson, dataObject,
			dataObject[0], dataObject[1], dataObject[2], dataObject[3]);

		dataOptional.ifPresent((Object o) -> {
			Object[] personReg = (Object []) dataOptional.orElseThrow();
			log.info("DATA-OPTIONAL  -  ID:{}, id={}, nombre={}, apellido={}, lenguaje={}", idPerson,
			personReg[0], personReg[1], personReg[2], personReg[3]);
		});
	}


	/* ************************************************************************************************************** */
	/* ************************************************************************************************************** */
	@Transactional
	public void create() {
		Person newPerson = new Person(null, "nombre1", "apellido1", "lenguaje1");
		Person savedPerson = repository.save(newPerson);
		repository.findById(savedPerson.getId()).ifPresent(System.out::print);
	}
	@Transactional
	public void update() {
		Person dataPerson = new Person(7L, "nombre2", "apellido2", "lenguaje2");

		Optional<Person> optPerson = repository.findById(dataPerson.getId());
		optPerson.ifPresent((Person personFound) -> {
			Person updatedPerson = repository.save(dataPerson);
			log.info("PERSONA-ACTUALIZADA: {}", updatedPerson);
		});
	}
	@Transactional
	public void delete() {
		Long idUser = 6L;
		Optional<Person> optPerson = repository.findById(idUser);
		if (optPerson.isPresent()) {
			repository.findAll().forEach(System.out::println);
			// repository.delete(optPerson.orElseThrow())
			repository.deleteById(idUser);
			repository.findAll().forEach(System.out::println);
			log.info("Usuario eliminado: {}", optPerson.orElseThrow());
		} else {
			log.info("No existe Usuario con ID:{}", idUser);
		}
	}
	@Transactional
	public void delete2() {
		Long idUser = 6L;
		Optional<Person> optPerson = repository.findById(idUser);
		optPerson.ifPresentOrElse(
			// (Person person) -> repository.delete(person),
			repository::delete,
			() -> log.info("No existe el usuario con ID:".concat(idUser.toString()))
		);
	}


	@Transactional(readOnly = true)
	private void find() {
		// findAllPersons();
		//-------------------------------------
		// findByProgrammingLanguage("java");
		// buscarByProgrammingLanguage("java");
		//-------------------------------------
		// findByProgrammingLanguageAndName("java", "Maria");
		// buscarByProgrammingLanguageAndName("java", "Maria");

		// obtenerPersonsData();
		obtenerUnaPerson();
	}


	private void obtenerUnaPerson() {
		int forma = 2;
		if (forma == 1) {
			Person persona = null;
			Optional<Person> optPerson = repository.findById(1L);
			if (optPerson.isPresent()) {
				log.info("PERSONA POR: querys-nativos\n");
				persona = optPerson.get();
				extracted(persona);
			}
		}
		if (forma == 2) {
			////////////////////////////DUDA////////////////////////////////////
			// Person personaCopia = null;
			// repository.findById(1L).ifPresent((Person p) -> personaCopia = p);
			////////////////////////////////////////////////////////////////////

			// repository.findById(1L).ifPresent((Person p) -> log.info(p.toString()));
			// repository.findOne(1L).ifPresent((Person p) -> log.info(p.toString()));

			// repository.findByName("Maria").ifPresent((Person p) -> log.info(p.toString()));
			// repository.findOneName("Maria").ifPresent((Person p) -> log.info(p.toString()));
			// repository.findOneName("Mariaa").ifPresent(System.out::print);

			// repository.findByNameStartingWith("Ma").ifPresent(System.out::print);
			repository.findOneLikeName("Ma").ifPresent(System.out::print);
		}
	}
	private void obtenerPersonsData() {
		List<Object[]> personsValues = repository.obtenerPersonsDataList();
		log.info("LISTADO DE PERSONAS POR: querys-nativos\n");
		showObject(personsValues);
	}
	private void buscarByProgrammingLanguageAndName(String programmingLanguage, String name) {
		List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguageAndName(programmingLanguage, name);
		log.info("LISTADO DE PERSONAS POR: querys-nativos\n");
		showPerson(persons);
	}
	private void buscarByProgrammingLanguage(String programmingLanguage) {
		List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage(programmingLanguage);
		log.info("LISTADO DE PERSONAS POR: querys-nativos\n");
		showPerson(persons);
	}

    private void findByProgrammingLanguageAndName(String programmingLanguage, String name) {
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName(programmingLanguage, name);
		log.info("LISTADO DE PERSONAS POR: campos-getter\n");
		showPerson(persons);
	}
	private void findByProgrammingLanguage(String programmingLanguage) {
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguage(programmingLanguage);
		log.info("LISTADO DE PERSONAS POR: campos-getters\n");
		showPerson(persons);
	}


	///////////////////////////////////////////////
	private void showPerson(List<Person> persons) {
		persons.stream()
			.forEach( System.out::println );
		System.out.println();
	}
	private void showObject(List<Object[]> personsObject) {
		personsObject.stream()
			.forEach( (Object[] objValues) -> {
				String[] stringValues = {objValues[0].toString(), objValues[1].toString()};
				System.out.println( objValues[0] + " <ES EXPERTO EN> " + objValues[1] );
				System.out.println( "\t-".concat(stringValues[0]).concat(" - ").concat(stringValues[1]) );
			});
		System.out.println();
	}
	/* ************************************************************************************************************** */
	/* ************************************************************************************************************** */


	private void findAllPersons() {
		List<Person> persons = (List<Person>) repository.findAll();
		log.info("LISTADO DE PERSONAS POR: campos-getter\n");
		persons.stream()
			// .forEach( (Person p) -> System.out.println(p) );
			// .forEach( System.out::println );
			// .forEach( (Person p) -> extracted(p) );
			.forEach( this::extracted );
	}
	private void extracted(Person p) {
		System.out.println(p);
	}
}
