package com.projectdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee extends Person {

	@Enumerated(EnumType.STRING)
	private Role role;

	public Employee(Long cpf, String name, Role role) {
		this.role = role;
		setCpf(cpf);
		setName(name);
	}

	// constructor for JPA
	protected Employee() {}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public enum Role {
		MANAGER,
		FRONT_DESK_STAFF,
		MECHANIC,
		INSTRUCTOR,
		SERVER,
		CLEANING_CREW,
		TECHNICIAN,
	}
}
