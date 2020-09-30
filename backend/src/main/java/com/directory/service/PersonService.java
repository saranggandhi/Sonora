package com.directory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.directory.exception.ResourceNotFoundException;
import com.directory.model.Person;
import com.directory.repository.PersonRepository;

@Repository
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public ResponseEntity<Person> updatePerson(Long personId, Person updatedPersonJson)
			throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

		person.setName(updatedPersonJson.getName());
		person.setEmail(updatedPersonJson.getEmail());
		person.setDob(updatedPersonJson.getDob());
		person.setCountry(updatedPersonJson.getCountry());
		person.setAvatar(updatedPersonJson.getAvatar());
		final Person updatedPerson = personRepository.save(person);
		return ResponseEntity.ok(updatedPerson);
	}

	public ResponseEntity<Person> getPersonById(Long personId) throws ResourceNotFoundException {
		Person person = personRepository.findById(personId)
				.orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
		return ResponseEntity.ok().body(person);
	}
}
