package com.projectdb.model;

import com.projectdb.db.Storage;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class RentalDAO {

	private EntityManager entityManager;

	public RentalDAO() {
		this.entityManager = Storage.getInstance().getEntityManager();
	}

	public List<Rental> getAllRental() {
		TypedQuery<Rental> query = entityManager.createQuery(
			"SELECT r FROM Rental r",
			Rental.class
		);
		return query.getResultList();
	}

	public void addRental(Rental newRental) {
		entityManager.persist(newRental);
	}

	public void finishRental(Rental rental) {
		entityManager.merge(rental);
	}
}
