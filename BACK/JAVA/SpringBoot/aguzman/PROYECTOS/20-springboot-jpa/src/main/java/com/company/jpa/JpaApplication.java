package com.company.jpa;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.Query;

import com.company.jpa.entitys.Person;
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
		// findAllPersons();
		//-------------------------------------
		// findByProgrammingLanguage("java");
		// buscarByProgrammingLanguage("java");
		//-------------------------------------
		// findByProgrammingLanguageAndName("java", "Maria");
		buscarByProgrammingLanguageAndName("java", "Maria");
	}
	private void show(List<Person> persons) {
		persons.stream()
			.forEach( System.out::println );
		System.out.println();
	}


	//////////////////////////////////////////
	private void buscarByProgrammingLanguageAndName(String programmingLanguage, String name) {
		List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguageAndName(programmingLanguage, name);
		log.info("LISTADO DE PERSONAS POR: querys-nativos\n");
		show(persons);
	}
	private void buscarByProgrammingLanguage(String programmingLanguage) {
		List<Person> persons = (List<Person>) repository.buscarByProgrammingLanguage(programmingLanguage);
		log.info("LISTADO DE PERSONAS POR: querys-nativos\n");
		show(persons);
	}

    private void findByProgrammingLanguageAndName(String programmingLanguage, String name) {
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguageAndName(programmingLanguage, name);
		log.info("LISTADO DE PERSONAS POR: campos-getter\n");
		show(persons);
	}
	private void findByProgrammingLanguage(String programmingLanguage) {
		List<Person> persons = (List<Person>) repository.findByProgrammingLanguage(programmingLanguage);
		log.info("LISTADO DE PERSONAS POR: campos-getters\n");
		show(persons);
	}


	///////////////////////////////////////////////////////////////////////////////
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
