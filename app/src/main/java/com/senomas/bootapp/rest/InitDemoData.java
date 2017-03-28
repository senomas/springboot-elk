package com.senomas.bootapp.rest;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.senomas.bootapp.rest.domain.Address;
import com.senomas.bootapp.rest.domain.Person;
import com.senomas.bootapp.rest.domain.Person.Gender;
import com.senomas.bootapp.rest.service.PersonService;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("demo")
public class InitDemoData {
	
	@Autowired
	PersonService personService;

	@PostConstruct
	public void init() {
		log.info("INIT DEMO DATA");
		for (int i=1; i<67; i++) {
			Person p = new Person("demo"+i, "last"+i);
			p.setGender(Gender.M);
			p.setDateOfBirth(new Date());
			p.addAddress(new Address("line"+i, "jakarta", "jakarta", "128"+i));
			personService.save(p);
		}
		log.info("DONE DEMO DATA");
	}
}
