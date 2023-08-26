package com.projectdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer extends Person {

	public Customer(Long cpf, String name) {
		setCpf(cpf);
		setName(name);
	}

	// constructor for JPA
	protected Customer() {}
}
