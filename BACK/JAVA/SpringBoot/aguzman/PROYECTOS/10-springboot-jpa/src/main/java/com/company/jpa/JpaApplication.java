package com.company.jpa;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Arrays;
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
		update();
		// delete();
		// find();
		/* *********** */

		// personalizedQueriesGenericOBJECT();
		// personalizedQueriesClassDTO();
		// personalizedQueriesDISTINCT();
		// personalizedQueriesUpperLowerCONCAT();
		// personalizedQueriesBETWEEN();
		// personalizedQueriesORDERBY();
		// personalizedQueriesFunctionAgregation();
		// personalizedSubQueries();
		// personalizedQueriesWhereIN();
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesWhereIN() {
		System.out.println("\n--------CONSULTA-WHERE-IN: LISTA-DE-IDS-----------");
		List<Person> personsIds =  repository.getPersonsById(Arrays.asList(1L, 5L, 6L));
	}


	@Transactional(readOnly = true)
	public void personalizedSubQueries() {
		System.out.println("\n--------OBTENER-ULTIMO-MAX(ID)-REGISTRADO-----------");
		Optional<Person> optUltimatePersonByMaxId = repository.getByIdLastRegistration();
		optUltimatePersonByMaxId.ifPresentOrElse(
			(Person per) -> System.out.println(MessageFormat.format("ultimatePERson:{0}\n", per)),
			() -> System.out.println("NO EXISTE PERSONA EN LA BASE DE DATOS")
		);


		// System.out.println(MessageFormat.format("\tALGO:{0}", programmingLanguageAndMoreUsed));
		System.out.println("\n--------AGRUPAR LENGUAJES_PROGRAMACION-Y-MOSTRAR-EL-MAS-USADO-----------");
		List<String[]> programmingLanguageAndMoreUsed = repository.groupByProgrammingLanguageAndShowMoreUsed();
		showStringFields(programmingLanguageAndMoreUsed);
		System.out.println("\n--------AGRUPAR LENGUAJES_PROGRAMACION-Y-MOSTRAR-EL-MAS-Y-MENOS-USADO-----------");
		List<String[]> programmingLanguageAndMoreLessUsed = repository.groupByProgrammingLanguageAndShowMoreLessUsed();
		showStringFields(programmingLanguageAndMoreLessUsed);
		System.out.println("\n--------AGRUPAR NOMBRE-Y-MOSTRAR:NOMBRE,APELLIDO,  TAMAÑO(NOMBRE){min-max}-----------");
		List<Object[]> groupByNameShowNameAndLastNameAndLengthName = repository.groupByNameAndShowNameLastnameWithLengthNameMinMax();
		showObject(groupByNameShowNameAndLastNameAndLengthName);
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesFunctionAgregation(){
		System.out.println("============PERSONS.FUNCIONES-AGREGACION============");
		Long totalPersonA = repository.count();
		Long totalPersonB = repository.totalPerson();
		System.out.println(MessageFormat.format("COUNT-CONTEO: \n\t-CrudRepository:{0},\t-IPersonaRepository:{1}\n", totalPersonA, totalPersonB));
		Long minimumPersonId = repository.minimumPersonId();
		Long maximumPersonId = repository.maximumPersonId();
		System.out.println(MessageFormat.format("MIN-MINIMO:{0}\nMAX-MAXIMO:{1}\n", minimumPersonId, maximumPersonId));
		Long summationPersonId = repository.summationPersonId();
		Double averagePersonId = repository.averagePersonId();
		System.out.println(MessageFormat.format("SUM-SUMATORIA:{0}\nAVG-PROMEDIO:{1}\n", summationPersonId, averagePersonId));
		System.out.println("\n--------RESUMEN-FUNCIONES-AGREGACION-----------");
		Object[] resumeAF = (Object[]) repository.getResumeAggregationFunction();
		System.out.println(MessageFormat.format(
			"min={0}\t,max={1}\t,sum={2}\t,avg={3}\t,count={4}"
			, resumeAF[0], resumeAF[1], resumeAF[2], resumeAF[3], resumeAF[4]));


		System.out.println("\n--------NOMBRE-Y-TAMAÑO_NOMBRE-CONTENIDOS-EN-UNA-LISTA-IDS(5,6)-----------");
		List<String[]> nameAndNameLengthWithId5And6 = repository.getNameAndNameLengthWithId5And6();
		showStringFields(nameAndNameLengthWithId5And6);
		nameAndNameLengthWithId5And6.stream().forEach((String[] fields) -> {
			String name = fields[0];
			String nameLength = fields[1];
			System.out.println(MessageFormat.format("\tname:{0}\tnameLength:{1}", name, nameLength));
		});

		System.out.println("\n--------CANTIDAD-CARACTERES-POR-NOMBRE-MINIMO-MAXIMO-----------");
		List<String[]> nameAndNameLength = repository.getNameAndNameLength();
		showStringFields(nameAndNameLength);

		System.out.println("\n--------AGRUPAR LENGUAJES_PROGRAMACION-Y-MOSTRAR-CANTIDAD-VECES-REPETIDOS-----------");
		List<String[]> programmingLanguageAndRepeatedQuantity = repository.groupProgrammingLanguageAndShowRepeatedQuantity();
		showStringFields(programmingLanguageAndRepeatedQuantity);

	}


	@Transactional(readOnly = true)
	public void personalizedQueriesORDERBY() {
		System.out.println("============PERSONS.NAME ORDER-BY============");
		List<Person> personsNamesA = repository.findAllNamesBetweenStarWithEndWithout("J", "P");
		showPerson(personsNamesA);
		List<Person> personsNamesD = repository.findByNameBetweenOrderByNameDescLastnameAsc("J", "P");
		showPerson(personsNamesD);
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesBETWEEN() {
		System.out.println("============PERSONS.ID BETWEEN 2,5============");
		List<Person> personsId = repository.findAllPersonByIdBetween2And5();
		showPerson(personsId);
		personsId = repository.findAllPersonByIdBetween(2L, 5L);
		showPerson(personsId);

		System.out.println("============PERSONS.BITHDAY BETWEEN '2002-02-12','2005-05-15'============");
		List<Person> personsBirthdayA = repository.findAllPersonByBirthdayBetween(
			LocalDate.parse("2002-02-12"), LocalDate.parse("2005-05-15"));
		showPerson(personsBirthdayA);

		List<Person> personsBirthdayB = repository.findByBirthdateBetween(
			LocalDate.parse("2002-02-12"), LocalDate.parse("2005-05-15"));
		showPerson(personsBirthdayB);
		System.out.println("============PERSONS.BITHDAY BETWEEN include'J' and before.'P'============");
		List<Person> personsNamesJP = repository.findAllNamesBetweenStarWithEndWithout();
		showPerson(personsNamesJP);
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesUpperLowerCONCAT() {
		System.out.println("============PERSONS NAME-LASTNAME============");
		List<String> listConcat =  repository.findAllFullNameConcat();
		showString(listConcat);
		System.out.println("============PERSONS LOWER-UPPER============");
		List<String[]> listConcatLowerUpper =  repository.findAllFullNameConcatOriginLowerUpper();
		showStringFields(listConcatLowerUpper);
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesDISTINCT() {
		/*OPERACIONES DE CONSULTA: distinc,concat,upper,like,betwwen*/
		System.out.println("============LISTA-PERSONS============");
		List<Person> listNames        = (List<Person>) repository.findAll();
		showPerson(listNames);
		System.out.println("============<DISTINC>.UNICS.NAMES============");
		List<String> listNamesDistinc = repository.findAllNamesDistinct();
		showString(listNamesDistinc);
		System.out.println("============<DISTINC>.UNICS.PROGRAMING-LENGUAGE============");
		List<String> listProgrammingLanguageDistinc = repository.findAllProgrammingLanguageDistinct();
		showString(listProgrammingLanguageDistinc);
		System.out.println("============COUNT<<DISTINC>>.UNICS.PROGRAMING-LENGUAGE============");
		Long countProgrammingLanguageDistinc = repository.countAllProgrammingLanguageDistinct();
		System.out.println("La cantidad de lenguajes unicos es:"+ countProgrammingLanguageDistinc);
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesClassDTO(){
		/*TIPOS DE RETORNO: CONCRETE-OBJECT-PERSON */
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
	}


	@Transactional(readOnly = true)
	public void personalizedQueriesGenericOBJECT() {
		/*TIPOS DE RETORNO: GENERIC-OBJECT*/
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
		Person newPerson = new Person(null, "nombre1", "apellido1", "lenguaje1", LocalDate.parse("2024-02-14"));
		Person savedPerson = repository.save(newPerson);
		repository.findById(savedPerson.getId()).ifPresent(System.out::print);
	}
	@Transactional
	public void update() {
		Person dataPerson = new Person(14L, "nombre2", "apellido2", "lenguaje2.1", LocalDate.parse("2023-05-27"));

		Optional<Person> optPerson = repository.findById(dataPerson.getId());
		optPerson.ifPresent((Person personFound) -> {
			personFound.setName(dataPerson.getName());
			personFound.setLastname(dataPerson.getLastname());
			personFound.setProgrammingLanguage(dataPerson.getProgrammingLanguage());
			personFound.setBirthdate(dataPerson.getBirthdate());

			Person updatedPerson = repository.save(personFound);
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
		showObjectWithTwoFieldsConvertString(personsValues);
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
	private void showString(List<String> strings) {
		strings.stream()
			.forEach( System.out::println );
		System.out.println();
	}
	private void showStringFields(List<String[]> strings) {
		strings.stream()
			.forEach( (String[] rows) ->  {
				List<String> fields = Arrays.asList(rows);
				System.out.println(fields);
			});
		System.out.println();
	}
	private void showObject(List<Object[]> personsObject) {
		personsObject.stream()
			.forEach( (Object[] rowsObjValues) -> {
				List<Object> fields = Arrays.asList(rowsObjValues);
				System.out.println(fields);
			});
		System.out.println();
	}

	private void showObjectWithTwoFieldsConvertString(List<Object[]> personsObject) {
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
