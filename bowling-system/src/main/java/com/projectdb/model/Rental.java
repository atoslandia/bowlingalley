package com.projectdb.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import java.time.LocalDateTime;

@Entity
@Table(
	name = "rentals",
	uniqueConstraints = @UniqueConstraint(columnNames = "lane_id")
)
public class Rental {

	@Id
	@Column(name = "rental_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "lane_id")
	private Lane lane;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "rental_timestamp")
	private LocalDateTime rentalDateTime;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "retunr_timestamp")
	private LocalDateTime returnDateTime;

	public Rental(
		Customer customer,
		Lane lane,
		LocalDateTime rentalDateTime
	) {
		this.customer = customer;
		this.lane = lane;
		lane.setAvailable(false);
		this.rentalDateTime = rentalDateTime;
		this.returnDateTime = rentalDateTime.plusHours(2);
	}

	// constructor for JPA
	protected Rental() {}

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

	public LocalDateTime getRentalDateTime() {
		return rentalDateTime;
	}

	public void setRentalDateTime(LocalDateTime rentalDateTime) {
		this.rentalDateTime = rentalDateTime;
	}

	public LocalDateTime getReturnDateTime() {
		return returnDateTime;
	}

	public void setReturnDateTime(LocalDateTime returnDate) {
		this.returnDateTime = returnDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return (
			"alugado por: " +
			getCustomer() +
			"\nna pista: " +
			getLane()
		);
	}
}
