package com.projectdb.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDateTime;

@Entity
@Table(name = "rentals")
public class Rental {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "lane_id")
	private Lane lane;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime rentalDate;

	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime returnDate;

	public Rental(Customer customer, Lane lane) {
		this.customer = customer;
		this.lane = lane;
		this.rentalDate = LocalDateTime.now();
	}

	// constructor for JPA
	protected Rental() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lane getLane() {
		return lane;
	}

	public void setLane(Lane lane) {
		this.lane = lane;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public LocalDateTime getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(LocalDateTime rentalDate) {
		this.rentalDate = rentalDate;
	}

	public LocalDateTime getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDateTime returnDate) {
		this.returnDate = returnDate;
	}
}
