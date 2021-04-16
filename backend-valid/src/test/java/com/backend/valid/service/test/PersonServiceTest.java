package com.backend.valid.service.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

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
		person.setProcessed(false);
		Person personDummy = service.save(person); 
		assertEquals(person, personDummy);
	}
	
	@Test
	public void updateProcessedTest() {
		Person person = new Person();
		person.setName("Paola");
		person.setLastName("España");
		person.setProcessed(false);
		service.save(person);
		service.updateProcessed(Arrays.asList(person.getId())); 
		assertTrue(person.getProcessed());
	}

}
