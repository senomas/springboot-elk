package com.senomas.bootapp.rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.senomas.bootapp.rest.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}