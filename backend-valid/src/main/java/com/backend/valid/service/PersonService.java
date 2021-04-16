package com.backend.valid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.backend.valid.data.Person;
import com.backend.valid.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Person save(Person person) {
		return personRepository.save(person);
	}

	public Page<Person> listPersons(Integer page, Integer size) {
		return personRepository.findAll(PageRequest.of(page, size));
	}

	private List<Person> listPersonsById(List<Long> personsIds) {
		return personRepository.findAllById(personsIds);
	}

	/**
	 * Updates a person's status to processed
	 * @param personsIds identifier of the persons to be processed
	 */
	public void updateProcessed(List<Long> personsIds) {
		List<Person> personsToProcessed = listPersonsById(personsIds);
		personsToProcessed.forEach((person) -> person.setProcessed(true));
		personRepository.saveAll(personsToProcessed);
	}
}
