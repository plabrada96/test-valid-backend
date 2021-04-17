package com.backend.valid.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import com.backend.valid.data.Person;
import com.backend.valid.service.PersonService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class PersonServiceTest {
	
	@Autowired
	private PersonService service;
	
	@Test
	public void saveTest() {
		Person person = new Person();
		person.setName("Paola");
		person.setLastName("España");
		Person personDummy = service.save(person); 
		assertEquals(person, personDummy);
	}
	
	@Test
	public void updateProcessedTest() {
		List<Person> personsList = service.listPersons(null, null).getContent();
		service.updateProcessed(Arrays.asList(personsList.get(0).getId())); 
		assertTrue(personsList.get(0).getProcessed());
	}
	
	@Test
	public void listPersonsTest() {
		List<Person> personsListWithPagination = service.listPersons(null, null).getContent();
		assertEquals(personsListWithPagination.size(), 1);
		List<Person> personsListWithOutPagination = service.listPersons(0, 2).getContent();
		assertEquals(personsListWithOutPagination.size(), 1);
	}

}
