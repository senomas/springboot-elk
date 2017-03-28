package com.senomas.bootapp.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.senomas.bootapp.rest.domain.Person;
import com.senomas.bootapp.rest.repository.PersonRepository;

@Service
@Transactional
public class PersonService {

	@Autowired 
	private PersonRepository repository;

	@Transactional(readOnly = true)
	public Page<Person> findAll(Pageable pageable) {
		
		return repository.findAll(pageable);
	}
	
	@Transactional(readOnly = true)
	public Person findOne(Long id) {
		
		return repository.findOne(id);
	}
	
	public Person save(Person person) {
		
		return repository.saveAndFlush(person);
	}
}
