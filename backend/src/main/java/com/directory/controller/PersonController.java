package com.directory.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.directory.exception.ResourceNotFoundException;
import com.directory.model.Person;
import com.directory.repository.PersonRepository;
import com.directory.service.PersonService;

@RestController
@RequestMapping("/api/People")
public class PersonController {

	@Autowired
	private PersonService personService;

	@Autowired
	private PersonRepository personRepository;
	
	/**
	 * Add person
	 * @param person
	 * @return
	 */
	@PostMapping
	public Person createPerson(@Valid @RequestBody Person person) {
		return personRepository.save(person);
	}

	/**
	 * Edit persons
	 * @param personId
	 * @param updatedPersonJson
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@PatchMapping("/{personId}")
	public ResponseEntity<Person> updatePerson(@PathVariable(value = "personId") Long personId,
			@Valid @RequestBody Person updatedPersonJson) throws ResourceNotFoundException {
		return personService.updatePerson(personId, updatedPersonJson);
	}

	/**
	 * List persons
	 * @return
	 */
	@GetMapping
	public List<Person> getAllEmployees() {
		return personRepository.findAll();
	}

	/**
	 * Get persons
	 * @param personId
	 * @return
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/{personId}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "personId") Long personId)
			throws ResourceNotFoundException {
		return personService.getPersonById(personId);
	}
	
}
