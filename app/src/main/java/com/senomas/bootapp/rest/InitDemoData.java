package com.senomas.bootapp.rest;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.github.javafaker.Faker;
import com.senomas.bootapp.rest.domain.Address;
import com.senomas.bootapp.rest.domain.Person;
import com.senomas.bootapp.rest.domain.Person.Gender;
import com.senomas.bootapp.rest.repository.PersonRepository;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@Profile("demo")
public class InitDemoData {
	
	@Autowired
	PlatformTransactionManager txManager;

	@Autowired
	PersonRepository personRepository;

	@PostConstruct
	public void init() {
		log.info("INIT DEMO DATA");
		TransactionTemplate tt = new TransactionTemplate(txManager);
		tt.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				for (int i=1; i<567; i++) {
					Faker faker = new Faker();
					
					Person p = new Person(faker.name().firstName(), faker.name().lastName());
					p.setGender(faker.bool().bool() ? Gender.M : Gender.F);
					p.setDateOfBirth(faker.date().past(30000, TimeUnit.DAYS));
					p.addAddress(new Address(faker.address().streetName(), faker.address().city(), faker.address().state(), faker.address().zipCode()));
					personRepository.save(p);
				}
			}
		});
		log.info("DONE DEMO DATA");
	}
}
