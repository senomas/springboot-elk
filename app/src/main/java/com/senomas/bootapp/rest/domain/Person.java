package com.senomas.bootapp.rest.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Entity
@Data
@JsonInclude(Include.NON_NULL)
public class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="person_id")
    private Long id;

    @NotNull
    @Column(name="first_name", nullable = false)
    private String firstName;

    @NotNull
    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="middle_name")
    private String middleName;

    @Column(name="dob")
    private Date dateOfBirth;
    
    @Column(name="gender")
    private Gender gender;
    
    @Valid
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id")
	private Set<Address> addresses;

    protected Person() {}

    public Person(Long id, String firstName, String lastName) {
    	this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public Person(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
	
	public void addAddress(Address address) {
		if (getAddresses() == null) {
			setAddresses(new HashSet<>());
		}
		getAddresses().add(address);
	}

	public static enum Gender {
		M, F;
	}

}