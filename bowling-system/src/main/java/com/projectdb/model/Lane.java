package com.projectdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lanes")
public class Lane {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int number;

	private boolean available;

	public Lane() {
		this.available = true;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String toString() {
		return "pista nº " + getNumber();
	}
}
