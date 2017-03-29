package com.senomas.bootapp.rest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Long id;

	@NotNull
 	private String line1;

	private String line2;
	
	@NotNull
	private String city;
	
	@NotNull
	private String state;
	
	@NotNull
	private String zip;

	public Address(String line1, String city, String state, String zip) {
		this.line1 = line1;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}
}
