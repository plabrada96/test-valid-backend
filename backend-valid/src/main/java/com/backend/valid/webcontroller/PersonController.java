package com.backend.valid.webcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.valid.constants.MappingConstants;
import com.backend.valid.constants.SwaggerConstants;
import com.backend.valid.data.Person;
import com.backend.valid.service.PersonService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = SwaggerConstants.API_VALUE_PERSON, tags = { SwaggerConstants.API_TAGS_PERSON })
@RequestMapping(SwaggerConstants.API_VALUE_PERSON)
@PropertySource("classpath:lang/lang-${demo.lang}.properties")
public class PersonController {

	@Autowired
	private PersonService personService;

	@PutMapping(MappingConstants.UPDATE_STANDARD)
	@ApiOperation(value = "${swagger.UPDATE_PERSON_PROCESSED}")
	public ResponseEntity<Void> updateProcessed(@RequestBody(required = true) List<Long> personsIds) {
		personService.updateProcessed(personsIds);
		return ResponseEntity
				.ok()
				.build();
	}

	@PostMapping(MappingConstants.SAVE_STANDARD)
	@ApiOperation(value = "${swagger.SAVE_PERSON}")
	public ResponseEntity<Person> save(@RequestBody(required = true) Person person) {
		return new ResponseEntity<>(personService.save(person),HttpStatus.CREATED);
	}

	@GetMapping(MappingConstants.SAVE_STANDARD)
	@ApiOperation(value = "${swagger.LIST_PERSONS}")
	public ResponseEntity<Page<Person>> list(@RequestParam(required = false) Integer page, @RequestParam(required = false) Integer size) {
		return new ResponseEntity<>(personService.listPersons(page, size),HttpStatus.OK);
	}
}
