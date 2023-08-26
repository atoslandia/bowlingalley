package com.projectdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(
	name = "persons",
	uniqueConstraints = @UniqueConstraint(columnNames = "cpf")
)
@Inheritance(strategy = InheritanceType.JOINED)
public class Person {

	@Id
	private Long cpf;

	private String name;

	public Long getCpf() {
		return cpf;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getName();
	}
}
